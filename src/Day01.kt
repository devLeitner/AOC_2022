fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }


    val elves = arrayListOf<Elf>()

    val input = readInput("resources/day1source")

    var elf: Elf = Elf(0)
    input.forEach{
        if(it.isBlank()){
            elves.add(elf)
            elf = Elf(0)
        }else{
            elf.calories += it.toInt();
        }
    }

    val maxElf = elves.maxBy { it.calories }
    elves.sortBy { it.calories }
    val maxElves = elves.subList(elves.size-3, elves.size)

    val result = maxElves.map {
        it.calories
    }.sum()
    print("\n$maxElf")
    print("\nTop 3 elves, sum of calories: $result")

}


data class Elf(var calories: Int)
