# Metronomia

a lifecycle aware metronome library with callbacks , dynamic tempo changer and all the other things you need for your app !



## features

+ start , stop and pause the metronome
+ dynamically change the tempo(bpm)
+ lifecycle awareness



## get Metronomia into your project

```css
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

```css
dependencies {
	        implementation 'com.github.AmirRezaSobhdel:Metronomia:1.0.2'
	}
```

## how to use

```kotlin
// initialize metronomia instance
var metronome = Metronomia(viewLifecycleOwner)

// start metronome with an specific tempo
metronome.startMetronome(tempo1)

// dynamically change the tempo
metronome.startMetronome(secondaryTempo)

// pause metronome and if you want to play just use the lines above
metronome.pauseMetronome()

// stop metronome
// it means you are clearing the current state of metronome
metronome.stopMetronome()
```