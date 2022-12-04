fun main(){
    fun part1(){
        println(readInput("/resources/day4source")
            .map {
                it.split(",").map {
                    it.trim().split("-")
                }
            }
            .map {
                it.map {
                    IntRange(it[0].toInt(), it[1].toInt()).toSet()
                }
            }.count {
                it[0].containsAll(it[1]) || it[1].containsAll(it[0])
            })
    }
    fun part2(){
        println(readInput("/resources/day4source")
            .map {
                it.split(",").map {
                    it.trim().split("-")
                }
            }
            .map {
                it.map {
                    IntRange(it[0].toInt(), it[1].toInt()).toSet()
                }
            }.count {
                it[0].any{inner -> inner in it[1]} || it[1].any{inner -> inner in it[0]}
            })
    }
    part1()
    part2()
}