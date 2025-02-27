package csi311.pro1.WyattBushman;

enum OperationType {
    EQUALS,
    NOT_EQUALS,
    LESS_THAN,
    LESS_THAN_OR_EQUALS,
    GREATER_THAN,
    GREATER_THAN_OR_EQUALS,
    LOGICAL_AND,
    LOGICAL_OR,
    LOGICAL_NOT,
    REGEX_MATCH,
    REGEX_NOT_MATCH,
    FIELD_SELECTOR,  // The $ operator
    PREFIX_INCREMENT,
    POSTFIX_INCREMENT,
    PREFIX_DECREMENT,
    POSTFIX_DECREMENT,
    UNARY_POSITIVE,
    UNARY_NEGATIVE,
    IN,
    EXPONENTIATION,  // This one's for the power operator
    ADDITION,
    SUBTRACTION,
    MULTIPLICATION,
    DIVISION,
    MODULUS,
    STRING_CONCATENATION,
    TERNARY_CONDITION,
}
