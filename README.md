# Plygrnd (Kotlin)
just my collection of android tools written in kotlin

## Gradle

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

```groovy
// kotlin is needed 
//org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.2.60
dependencies {
    implementation 'com.github.raquezha:plygrnd:/releases/latest'
}
```

## Usage

initialize this in your application
```kotlin
Playground.with(application)
```
or you can add custom tag name for logs by default it is set to **Playground**
```kotlin
Playground.with(application, "MyCustomTagName")
```

### Keyboard Visibility Listener

to use it first declare a listener
```kotlin
val listener = object : OnKeyboardVisibilityListener {
    override fun onVisibilityChanged(visible: Boolean) {
        ...
    }
}
// then you can use it via activity
activity.setKeyboardVisibilityListener(listener)
```

### LogExt

```kotlin
log("my log message")
```

### ToastExt

```kotlin
toast("my log message")
```
