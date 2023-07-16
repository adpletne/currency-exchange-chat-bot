theme: /exchangeRate
    
    state: ExchangeRate
        # курс евро
        q!: * ~курс {[какой/кокой] [[на] $todayAdv]} [у/для] $currency *
        q!: * $currency {[какой/кокой] [[на] $todayAdv]} ~курс *
        script:
            if (
                $parseTree._todayAdv || 
                $nlp.matchPatterns($request.query, ["* $todayAdv *"])
                ) {
                    if ($parseTree._currency === "EUR" || $parseTree._currency === "USD") {
                        var currency = $parseTree._currency;
                        var url = "https://www.cbr-xml-daily.ru/daily_json.js";
                        var response = $http.get(url);
                        if (response.isOk) {
                            // баг - невозможно достать из объекта нужное число
                            var rate = response.data.Valute[currency].Value;
                        }
                        $reactions.answer("Курс " + currency + " сегодня - " + rate + "руб.");
                    } else {
                        return $reactions.transition("/exchangeRate/ICanTellOnlyAboutDollarAndEuroRate");
                    }
                } else {
                    return $reactions.transition("/exchangeRate/ICanTellOnlyAboutTodayExchangeRate");
                }
                
            
    state: ICanTellOnlyAboutTodayExchangeRate
        a: Я могу рассказать только о сегодняшнем курсе.
        
        
    state: ICanTellOnlyAboutDollarAndEuroRate
        a: Я могу рассказать только о курсе доллара и евро.

