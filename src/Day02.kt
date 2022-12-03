import RPS.*
import RPSRESULT.*

fun main() {
    fun part1() {
        val input = readInput("./resources/day2source")

        val list = arrayListOf<Array<String>>()
        input.forEach {
            list.add(arrayOf(it.split(" ")[0], it.split(" ")[1]))
        }

        val enumList = arrayListOf<List<RPS>>()
        list.forEach {
            enumList.add(it.map { it.toEnum() })
        }


//    print("$enumList\n")
        var totalScore: Int = 0

        enumList.forEach {
            totalScore += it[0].vs(it[1])
        }

        print(totalScore)


    }
    fun part2() {
        val input = readInput("resources/day2source")
        val list = arrayListOf<Array<String>>()
        input.forEach {
            list.add(arrayOf(it.split(" ")[0], it.split(" ")[1]))
        }

        val enumList = arrayListOf<Part2>()

        list.forEach {
            enumList.add(Part2(it[0].toEnum(), it[1].toResult()))
        }

        var totalScore = 0
        enumList.forEach {
            val score = it.result.getScore(it.rps)
            totalScore += score
            print("$it with $score \n")
        }


        print(totalScore)
    }

//    part1()
    part2()
}





internal data class Part2(val rps: RPS, val result: RPSRESULT)

internal fun String.toEnum(): RPS {
    if (this == "A" || this == "X") return ROCK
    if (this == "B" || this == "Y") return PAPER
    if (this == "C" || this == "Z") return SCISSORS
    throw Exception("wrong type for RPS")
}

internal fun String.toResult(): RPSRESULT {
    if (this == "X") return LOSS
    if (this == "Y") return DRAW
    if (this == "Z") return WIN
    throw Exception("wrong type for RPSResult")
}

internal fun RPS.vs(enemy: RPS): Int {
    val score = enemy.calcFunc(this) + enemy.score
    print("his: $this me: $enemy score for me: $score \n")
    return score
}

internal enum class RPS(val score: Int, val calcFunc: (enemy: RPS) -> Int) {
    ROCK(1, { enemy ->
        when (enemy) {
            SCISSORS -> 6
            ROCK -> 3
            PAPER -> 0
        }
    }),
    PAPER(2, { enemy ->
        when (enemy) {
            SCISSORS -> 0
            ROCK -> 6
            PAPER -> 3
        }
    }),
    SCISSORS(3, { enemy ->
        when (enemy) {
            SCISSORS -> 3
            ROCK -> 0
            PAPER -> 6
        }
    });
}

internal fun RPSRESULT.getScore(enemy: RPS) = when (this) {
    WIN -> enemy.getWinner().score + 6
    DRAW -> enemy.score + 3
    LOSS -> enemy.getLoss().score + 0
}


internal fun RPS.getLoss() = when (this) {
    ROCK -> SCISSORS
    PAPER -> ROCK
    SCISSORS -> PAPER
}

internal fun RPS.getWinner() = when (this) {
    ROCK -> PAPER
    PAPER -> SCISSORS
    SCISSORS -> ROCK
}


internal enum class RPSRESULT() {
    DRAW,
    WIN,
    LOSS
}


