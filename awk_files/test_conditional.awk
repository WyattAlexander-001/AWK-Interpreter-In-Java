BEGIN {
    print "=== Starting Conditional Test ==="
}

{
    # If the first field is numeric and > 10:
    if ($1 > 10) {
        print "Line", NR, "has first field > 10:", $1
    }
    # Else if the first field is exactly 10:
    else if ($1 == 10) {
        print "Line", NR, "has first field == 10:", $1
    }
    # Otherwise if the field is less than or not numeric:
    else {
        print "Line", NR, "has first field <= 10 or non-numeric:", $1
    }
}

END {
    print "=== End of Conditional Test ==="
}
