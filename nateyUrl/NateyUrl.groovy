class NateyUrl {

    def base62Numerals = "0123456789" + ("a" .. "z").join('') + ("A" .. "Z").join('')

    String getUrl(Long i) {
        def possibleNumbers = base62Numerals.length()
        def url = ""

        while(true) {
            // divide i by the amount of numerals we can assign
            // take the remainder, and find the character that represents our number
            // in our fictional number system, meow.
            def remainder = i % possibleNumbers         // Ex:  63 % 62 = 1
            // find the character representation for our numeral
            def nextChar = base62Numerals[remainder.toInteger()]
            url = nextChar + url

            // now, skip to the next set of crap.
            // For example if we start with 100, now we'll have 1.
            i = i.intdiv(possibleNumbers)
            if (i == 0) { break }
        }
        return url
    }

}
