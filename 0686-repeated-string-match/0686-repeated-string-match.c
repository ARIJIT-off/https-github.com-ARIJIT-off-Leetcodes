int repeatedStringMatch(char* a, char* b) {
    int lenA = strlen(a);
    int lenB = strlen(b);
    int count = (lenB + lenA - 1) / lenA;
    char* repeated = (char*)malloc(sizeof(char) * (lenA * (count + 2) + 1));
    if (!repeated) return -1;
    repeated[0] = '\0';
    for (int i = 0; i < count; i++) {
        strcat(repeated, a);
    }
    if (strstr(repeated, b) != NULL) {
        free(repeated);
        return count;
    }
    strcat(repeated, a);
    count++;
    if (strstr(repeated, b) != NULL) {
        free(repeated);
        return count;
    }
    strcat(repeated, a);
    count++;
    if (strstr(repeated, b) != NULL) {
        free(repeated);
        return count;
    }
    free(repeated);
    return -1;
}   