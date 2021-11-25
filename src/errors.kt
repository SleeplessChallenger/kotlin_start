import java.lang.IllegalArgumentException
import java.lang.IndexOutOfBoundsException
import java.lang.NumberFormatException

// use <Any> type as values can be anything
// use <vararg> as we can have multiple values
class WrongOperatorException(
    value: Any,
    message: String,
): IllegalArgumentException("$message: $value")

class WrongValueException(
    message: String,
    vararg args: Any?,
): NumberFormatException("$message: $args")

class WrongNumberArgs(
    message: String
): IndexOutOfBoundsException(message)
