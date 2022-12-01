fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }


    var elves = arrayListOf<Elf>()

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

    print(elves)
    var maxElf = elves.maxBy { it.calories }
    print("\n" + maxElf)

}


data class Elf(var calories: Int)
