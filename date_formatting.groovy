#!/usr/bin/env groovy -w

c= new GregorianCalendar(2009, Calendar.JULY, 22, 16, 20, 21)
    //creates 22 July 2009 at 4:20:21pm GMT
//shortcut formats...
//
//
assert String.format('%tF', c) == '2009-07-22' //date as '%tm/%td/%ty', String.format('%tF', c)
// 13 Feb '09 - 6.27pm
print String.format('%td %<tb \'%<ty - %<tl.%<tM%<tp', c) //date as '%tm/%td/%ty', String.format('%tF', c)
assert String.format('%tD', c) == '07/22/09' //date as '%tY-%tm-%td'
assert String.format('%tT', c) == '16:20:21' //time as '%tH:%tM:%tS'
assert String.format('%tR', c) == '16:20' //time as '%tH:%tM'
assert String.format('%tr', c) == '04:20:21 PM' //time as '%tI:%tM:%tS %Tp'
