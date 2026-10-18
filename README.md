# Censorship 🔤

**Completed:** December 20, 2025

Censorship is a Java command-line application that reads a plain-text file and replaces words or expressions from a configurable blacklist with `***`. This public version uses **harmless example words** to demonstrate the algorithm without including offensive vocabulary.

I developed this project to practice Java text processing, regular expressions, file reading, and organizing a program into multiple classes.

## Features

- **Configurable blacklist:** Edit the example words in `CurseWords.java` to choose which text to filter.
- **Case-insensitive matching:** Finds words regardless of capitalization.
- **Automatic replacement:** Replaces each matched expression (and matching word characters immediately after it) with `***`.
- **Text-file input:** Reads a provided `.txt` file or the included example.
- **Terminal output:** Shows the censored text without modifying the original file.
- **No third-party dependencies:** Uses only standard Java APIs.

## Requirements

- Java Development Kit (JDK) 11 or newer
- No additional libraries

## Installation

1. Download or clone this repository.
2. Open a terminal in the repository's root folder (the folder containing `Text_file.txt`).
3. Create a directory for compiled files if it does not already exist:

   ```bash
   mkdir bin
   ```

4. Compile the Java source files:

   ```bash
   javac -encoding UTF-8 -d bin src/MainUser.java src/CurseChecker.java src/CurseWords.java src/TxtReader.java
   ```

5. Start the program:

   ```bash
   java -cp bin MainUser
   ```

## How to Use

When the program asks for a text-file location, either:

- Type `NO` or simply press Enter to process the included `Text_file.txt`.
- Enter a path to your own text file to process that file instead.

The program prints the censored text in the terminal. It **does not overwrite or save** the original file.

### Example

**Original text:**

```text
Today I bought a banana and an apple.
Someone shouted SPOILER during the movie.
The note contained a secret message.
```

**Output:**

```text
Today I bought a *** and an apple.
Someone shouted *** during the movie.
The note contained a *** message.
```

## Customizing the Blacklist

Open `src/CurseWords.java` and edit the list:

```java
public static final List<String> cuss_words = new ArrayList<>(List.of(
    "banana", "spoiler", "secret"
));
```

These are intentionally harmless demonstration words. You can add or remove entries as needed, then recompile the program.

The existing class and field names are retained for compatibility with the original implementation.

## How It Works

The project uses four Java classes:

### 1. MainUser.java — Main Application

Controls the application's execution, asks the user which file to process, and displays the resulting censored text.

### 2. TxtReader.java — File Reading

Uses Java's built-in file API to read the contents of a text file:

```java
String text = Files.readString(Path.of(txt_path));
```

### 3. CurseWords.java — Blacklist Storage

Stores the words to filter in a `List<String>`.

The example blacklist can be expanded or modified by editing the Java file.

### 4. CurseChecker.java — Censorship Algorithm

Contains the main censorship logic.

The method `chackerCURSE()` loops through the blacklist and applies a regular expression to the input text.

```java
text = text.replaceAll("(?i)" + word + "\\w*", "***");
```

The expression works as follows:

- `(?i)` enables case-insensitive matching.
- `word` represents the current blacklist entry.
- `\\w*` matches zero or more following word characters.
- `replaceAll()` replaces matching text with `***`.

Because the expression does not require a word boundary at the beginning, matching text can also be detected inside longer words.

## Project Structure

```text
Censorship/
├── src/
│   ├── MainUser.java
│   ├── TxtReader.java
│   ├── CurseChecker.java
│   └── CurseWords.java
├── Text_file.txt
├── .gitignore
└── README.md
```

Compiled `.class` files and the `bin/` directory are excluded from version control.

## Known Limitations

- **Partial matches:** The filter can censor parts of otherwise harmless longer words because it does not require whole-word boundaries.
- **Regular-expression entries:** Blacklist strings are used directly as regular expressions; special regex characters would need escaping to be treated literally.
- **Unicode handling:** The `\\w*` expression does not reliably cover all accented letters in longer words.
- **No output file:** Results are only printed to the terminal.
- **No graphical interface:** The program runs in a terminal.
- **Limited error handling:** Invalid or inaccessible file paths cause the program to report an error and exit rather than offering a retry.

## Development Note

This project was created as a Java learning exercise using multiple classes, lists, loops, file I/O, and regular expressions.

The original blacklist has been replaced with non-offensive demonstration entries so the public repository is appropriate for a school and professional portfolio.



**Author:** [Nik Berginc](https://github.com/nikberginc)
