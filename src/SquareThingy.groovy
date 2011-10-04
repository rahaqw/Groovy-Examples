class SquareThingySomething {
    def squareList = []
    def SquareThingySomething(initList) {
        initList.eachWithIndex { obj, index ->
            def (x,y) = computeGrid(index, initList.size())
            if (!squareList[x]) squareList[x] = [];
            squareList[x][y] = obj
        }
    }

    def computeGrid(index, total) {

        def row = (index / numItemsInRow(total)).toInteger()
        def col = index % (numItemsInRow(total))
        return [ row, col ]

    }

    def numItemsInRow(total) {
        if (total <= 2) { return total }
        Math.ceil(Math.sqrt(total)).toInteger()
    }
        
}

def mythingy = new SquareThingySomething([1,2,3])
println mythingy.squareList

mythingy = new SquareThingySomething([1,2,3,null,5,6])
println mythingy.squareList
mythingy = new SquareThingySomething([1,2,3,null, 'a', 'b', 'c'])
println mythingy.squareList

mythingy = new SquareThingySomething('a' .. 'z')
println mythingy.squareList
/*
println mythingy.numItemsInRow(1)
println mythingy.numItemsInRow(2)
println mythingy.numItemsInRow(3)
println mythingy.numItemsInRow(4)
println mythingy.numItemsInRow(5)
println mythingy.numItemsInRow(6)
println mythingy.numItemsInRow(7)
println mythingy.numItemsInRow(8)

println mythingy.computeGrid(0,9)
println mythingy.computeGrid(1,9)
println mythingy.computeGrid(2,9)
println mythingy.computeGrid(3,9)
println mythingy.computeGrid(4,9)
println mythingy.computeGrid(5,9)
println mythingy.computeGrid(6,9)
println mythingy.computeGrid(7,9)
println mythingy.computeGrid(8,9)
*/

