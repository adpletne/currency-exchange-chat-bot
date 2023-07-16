theme: /exchangeRate
    
    state: ExchangeRate
        # курс евро
        q!: * ~курс {[какой/кокой] [[на] $todayAdv]} [у/для] $currency *
        q!: * $currency {[какой/кокой] [[на] $todayAdv]} ~курс *
        script:
            //if (
                //$parseTree._todayAdv //|| 
                //$nlp.matchPatterns($request.query, ["* $todayAdv *"])
                //) {
                    //if ($parseTree._currency === "евро" || $parseTree._currency === "доллар") {
                        //var query = $parseTree.currency.value;
                        //var url = "https://www.cbr-xml-daily.ru/";
                        //var response = $http.get(url);
                        //$reactions.answer(response);
                        //if (response.isOk) {
                            //var rate = 0;//response.data.current.temperature;
                        //}
                    //$reactions.answer("Курс " + query + " сегодня - " + rate);
                    //}
                    //$reactions.transition("/exchangeRate/ICanTellOnlyAboutDollarAndEuroRate");
                //}
                //$reactions.transition("/exchangeRate/ICanTellOnlyAboutTodayExchangeRate");
                //}
                
            
    state: ICanTellOnlyAboutTodayExchangeRate
        a: Я могу рассказать только о сегодняшнем курсе.
        
        
    state: ICanTellOnlyAboutDollarAndEuroRate
        a: Я могу рассказать только о курсе доллара и евро.

