# Metronomia

a lifecycle aware metronome library with callbacks , dynamic tempo changer and all the other things you need for your android app !



![metronome](https://github.com/AmirRezaSobhdel/Metronomia/blob/master/metronome.png)



### features

+ start , stop and pause the metronome
+ dynamically change the tempo(bpm)
+ lifecycle awareness



### get Metronomia into your project

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
	        implementation 'com.github.AmirRezaSobhdel:Metronomia:1.0.0'
	}
```

### how to use

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

### License

```
Copyright 2020 AmirRezaSobhdel

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
