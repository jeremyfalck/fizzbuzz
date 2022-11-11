# FizzBuzz Test App
---

## Clean Architecture

This test app is an example of clean architecture application, where the whole project is divided in
layer modules :

- **Presentation (UI Layer)**
- **Domain (business logic layer)**
- **Data (data sources layer)**

Each module has its own `build.gradle` file, meaning that some dependencies will only be available
in some of them.

For example, every Android Framework dependency will be used only in the **Presentation layer**. The
rest must be independant from the framework.

## Libraries Used

This project is a **simple infinite scrolling calculator**.

To implement infinite scrolling,
the [Jetpack Paging Library](https://developer.android.com/topic/libraries/architecture/paging/v3-overview)
is implemented, and integrated in a regular `RecyclerView`.

The calculations are all made **asynchronously** thanks
to [Kotlin Flows](https://developer.android.com/kotlin/flow)

Further more, whilst the **Dependency Inversion Principle** is respected, every interface
implementation is injected
with [Hilt](https://developer.android.com/training/dependency-injection/hilt-android), which helps
exploiting abstractions, and **optimize performance**.

Here are the three libs used in the project :

- **Hilt**
- **Jetpack Paging**
- **Jetpack Navigation**

There is no need to add HTTP libraries nor Database libraries, but if necessary it would be done
only in the **Data layer**

## Production ready APK

For the release build, the app is **shrinked**
with [R8](https://developer.android.com/studio/build/shrink-code), which is the new default shrinker
in Android Studio 4.0.

That way the code is minimized, and obfuscated.

For example, the debug APK is **5.7MB**, and the release APK is **2.1MB**.

You can sign this app with your own key, and upload it to the Play Store.

## Error Handling

The errors are thrown from the **domain layer**, and caught in the **presentation layer**. The error
is then displayed to the user through a single instance `Snackbar`.







