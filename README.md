# Spanish Vocabulary Learning Java App "Hablamos Espanol!"

## Project name
**EspanolApp** &mdash; *Spanish vocabulary learning Java app*.

## Project description
The Vocabulary Learning App is a Java-based application designed to help users learn and practice 
Russian-Spanish word pairs. Users can:
- add / remove / replace words in their vocabulary;
- engage in vocabulary training exercises to test their knowledge. 

The app provides a range of features to enhance the vocabulary learning experience, including 
sorting words alphabetically and providing random facts about Spain.

## Technical requirements
- Java version: Oracle OpenJDK version 19.0.2
- Dependencies: JUnit 5.8.1

### Entry point of the application
AppRunner

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
- **VocabularyTraining** is tested in the *VocabularyTrainingTests*.
- 





