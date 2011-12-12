#!/usr/bin/env groovy
// New dates as of Groovy 1.5.7 -- Much simpler
def d = Date.parse('MM/dd/yyyy', '07/22/2009')
assert d.format('MM/dd/yyyy') ==  '07/22/2009'
assert d.format('MMMM d, yyyy') == 'July 22, 2009'


// Old-school
c= new GregorianCalendar(2009, Calendar.JULY, 22, 16, 20, 21)
assert String.format('%tF', c) == '2009-07-22' //date as '%tm/%td/%ty', String.format('%tF', c)
// 13 Feb '09 - 6.27pm
// date as '%tm/%td/%ty', String.format('%tF', c)
// print String.format('%td %<tb \'%<ty - %<tl.%<tM%<tp', c) 
assert String.format('%tD', c) == '07/22/09' //date as '%tY-%tm-%td'
assert String.format('%tT', c) == '16:20:21' //time as '%tH:%tM:%tS'
assert String.format('%tR', c) == '16:20' //time as '%tH:%tM'
assert String.format('%tr', c) == '04:20:21 PM' //time as '%tI:%tM:%tS %Tp'
assert String.format('%tI:%<tM %<tp', c) == '04:20 pm'



//date as YYYYMMDD 
assert String.format('%tY%<tm%<td', c) == '20090722' 
assert d.format('yyyyMMdd') == '20090722'
