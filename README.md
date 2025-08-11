# Spanish Vocabulary Learning Java Console App

## Project name
**EspanolApp** &mdash; *Spanish vocabulary learning Java console app*.

## Project description
This spanish vocabulary learning app is a Java-based console application designed to help users learn and practice 
Russian-Spanish word pairs. Users can:
- add / remove / replace words in their vocabulary which are stored in the txt file;
- engage in vocabulary training exercises to test their knowledge;
- get random facts about Spain.

The app provides a range of features to enhance the vocabulary learning experience, including 
sorting words alphabetically and providing random facts about Spain.

## Technical requirements
- Java version: Oracle OpenJDK version 19.0.2
- Dependencies: JUnit 5.8.1

### Entry point of the application
AppRunner

### How to use the app:
1. Clone the repository in the terminal:
##
   <tab>git clone https://github.com/TinyaPetrova/EspanolApp.git HablamosEspanol<tab>

2. Reach the created folder:
##
   <tab>cd HablamosEspanol<tab>

3. Compile and run the program.

   For Windows (MinGW/MSYS2, Git Bash), Linux (Ubuntu/Debian/Fedora/Arch),
   MacOS:
##
   <tab>javac -d out $(find src -name "*.java") && java -cp out app.AppRunner<tab>

   For Windows (Command Prompt / CMD):
##
   <tab>javac -d out src\*.java && java -cp out app.AppRunner<tab>

   For Windows PowerShell:
##
   <tab>javac -d out (Get-ChildItem -Recurse -Filter *.java).FullName | ForEach-Object { $_.ToString() } && java -cp out app.AppRunner<tab>
  
Note:
Due to the use of special characters and emoji, the display of information in the console may be different depending on the shell you are using.

### Necessary files and resources
- Vocabulary data is stored in a text file located at res/MyVocabulary.txt
- Random facts about Spain are loaded from the file res/RandomFacts.txt

## General structure description
The project has a modular structure with separate packages for different components.

### Class structure
- **AppRunner**: the entry point of the application.
- **MenuManager**: manages the main menu and user's interactions.
- **VocabularyManager**: responsible for vocabulary management, storage, and training.
- **VocabularyTraining**: manages the vocabulary training exercises.
- **InterestingFacts**: provides random facts about Spain.

### Relationship between classes
- **AppRunner** initializes the **MenuManager**, which, in turn, interacts with other components.
- **MenuManager** uses the **VocabularyManager** to manage vocabulary-related operations and the 
**VocabularyTraining** to conduct exercises and assess user's performance.
- **VocabularyManager** interacts with the **InterestingFacts** class to provide random facts.

## Testing (in progress)
- Test classes are located in the 'test' package. 
- JUnit 5 is used for unit testing. 
- **VocabularyManager** is tested in the *VocabularyManagerTests*.
- Work on tests is still in progress.
- **VocabularyTraining** is tested in the *VocabularyTrainingTests*.
- **VocabularyComparators** is tested in the *VocabularyComparatorsTests*





