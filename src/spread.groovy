def myprintln(Object[] args) {
    println "I got ${args.size()} arguments"
    args.each {
        println it.inspect()
    }
}
                
def args = [['foo', 'bar'], 1]
println "\n spread"
myprintln(*args)
println "\n NO spread"
myprintln(args)
