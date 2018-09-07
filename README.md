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

## AndroidX

this project uses androidx; add the following lines to your gradle.properties file:
```groovy
android.useAndroidX=true
android.enableJetifier=true
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

to use it first declare a listener, then you can use it via activity

```kotlin
val listener = object : OnKeyboardVisibilityListener {
    override fun onVisibilityChanged(visible: Boolean) {
        ...
    }
}

activity.setKeyboardVisibilityListener(listener)
```

### Show/Hide Keyboard

just call 'showKeyboard()' function anywhere inside your  Activity or View

```kotlin
showKeyboard()
```

```kotlin
hideKeyboard()
```

### LogExt

```kotlin
log("my log message")
```

### ToastExt

```kotlin
toast("my log message")
```
