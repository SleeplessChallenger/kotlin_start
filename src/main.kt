
fun main() {

    println("Please, enter an arithmetic problem: ")
    var input: String? = readLine()

    while (input != null && input.isNotBlank()) {
        println("You entered: $input")

        val tempValues = input.split(' ')

        // strip() all blanks
        val values = tempValues.filter { it != "" }

        if(values.size < 3) {
            throw WrongNumberArgs(
                "You don't have enough values"
            )
        }

//        val someVal: Double = values[0].toDoubleOrNull() ?: throw WrongValueException(
//            "Check your values: ",
//            values[0]
//        )

        val leftVal: Double? = try { values[0].toDouble() } catch (e: NumberFormatException) { null }
        val rightVal: Double? = try { values[2].toDouble() } catch (e: NumberFormatException) { null }

        val op = values[1]

        when {
            leftVal == null && rightVal == null -> {
                throw WrongValueException(
                    "Check your values: ",
                    leftVal, rightVal
                )
            }
            leftVal != null && rightVal == null -> {
                throw WrongValueException(
                    "Check your values: ",
                    leftVal
                )
            }
            rightVal != null && leftVal == null -> {
                throw WrongValueException(
                    "Check your values: ",
                    rightVal
                )
            }
        }

        when (op) {
            "+" -> println(leftVal!! + rightVal!!)
            "-" -> println(leftVal!! - rightVal!!)
            "/" -> println(leftVal!! / rightVal!!)
            "*" -> println(leftVal!! * rightVal!!)
            else -> throw WrongOperatorException(
                op,
                "Pay attention to operator"
            )
        }
        input = readLine()

    }

    println("Finish!")
}
