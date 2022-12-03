fun main(){
    fun part1(){
        var input = readInput("resources/day3source")


        var pairList = input.map {
            Pair(it.subSequence(0, it.length/2),it.subSequence(it.length/2, it.length))
        }
        println(pairList)

        var totalScore = 0
        pairList.forEachIndexed{index, pair ->
            pair.first.forEach{
                if (pair.second.contains(it)) {
                    println("$it with score(${it.code}) to ${calcScore(it)} at index $index")
                    totalScore += calcScore(it)
                    return@forEachIndexed
                }
            }
        }
        print(totalScore)
    }

    fun part2(){
        print(readInput("resources/day3source")
            .chunked(3)
            .map {
                Triple(it[0].toCharArray(), it[1].toSet(), it[2].toSet())
            }.sumOf {
                calcScore(
                    it.first.intersect(it.second)
                        .intersect(it.third)
                        .first()
                )
            })
    }
    part2()
//    part1()
}

internal fun calcScore(x:Char) = if(x.code >= 97) x.code - 96 else x.code - 38


