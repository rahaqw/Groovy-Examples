// TOTAL HACK  TOTAL HACK I HATE GROOVY
def cal = Calendar.instance
def Y = cal.get(Calendar.YEAR) - 1900
def M = cal.get(Calendar.MONTH)
def D = cal.get(Calendar.DAY_OF_MONTH)

println "Year = " + Y
println "Month" + M
println "Day" + D
def today = new Date(Y, M, D)
println " the first thingy today is: " + today
