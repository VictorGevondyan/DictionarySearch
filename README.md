# DictionarySearch
A android app that allows to search translation of word in online dictionary. Implemented using ViewModels and Room together with RxJava & Dagger2, in Kotlin by Clean Architecture.

### Implemented by Clean Architecture
The structure of this project consist of 3 layers:
- Presentation
- Domain
- Data

### Communication between layers

1. UI calls method from ViewModel.
2. ViewModel executes Use case.
3. Use case gets data from Repository.
4. Each Repository returns data from a Data Source (Cached or Remote).
5. Information flows back to the UI where we display the list of words.



### Scenario

At a glance:

- Search word by name
- Get a list of Word results, and display it.
- In the Item of each Word, showed Word name.
- When user taps on Word, new page will be shown which includes details of word.
- Were Written test to cover one simple case.
- Supported orientation change.
   
### Third-party libraries

Retrofit2, OkHttp - for network calls.
RxJava - for reactive programming, multithreading.
Room - for persistent storage.
Hilt - for Dependency Injection.
Glide - for effective image loading and displaying.
Multidex - for dealing with app big size.
Espresso - for Instrumented Tests.
Robolectric - for unit tests.