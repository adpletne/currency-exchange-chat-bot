theme: /communicative
    
    state: Hello
        # привет
        q!: {$hello $youDat $botDatNom}
        a: Доброго времени суток!
        
        
    state: Bye
        # пока бот
        q!: {$bye $youDat $botDatNom}
        a: До встречи!
        
        
    state: Thanks
        # спасибо тебе
        q!: {$thanks $youDat $botDatNom}
        a: Всегда помогу, если смогу.
