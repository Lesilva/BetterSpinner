# BetterSpinner
If you like developing Android, you must "hate" Spinners. I had countless issues with Spinners and I decided to make a new one. BetterSpinner is using AutoCompleteTextView to do what a Spinner really should do.

## Screenshots
![BetterSpinner](./screenshot/screenshot.gif)

## Examples
The demo is a showcase of the functionality of the library.

 [![Get it on Google Play](https://developer.android.com/images/brand/en_generic_rgb_wo_60.png)](https://play.google.com/store/apps/details?id=com.weiwangcn.betterspinner.sample)

## Usage
BetterSpinner can be used just like [AutoCompleteTextView](http://developer.android.com/reference/android/widget/AutoCompleteTextView.html).

```java
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                 android.R.layout.simple_dropdown_item_1line, COUNTRIES);
         BetterSpinner textView = (BetterSpinner)
                 findViewById(R.id.countries_list);
         textView.setAdapter(adapter);
     }

     private static final String[] COUNTRIES = new String[] {
         "Belgium", "France", "Italy", "Germany", "Spain"
     };
```

or you can also store you arrays in arrays.xml and do something like this in your code

```java
String[] COUNTRIES = getResources().getStringArray(R.array.countries_list);
```

If you want to use material style AutoCompleteTextView, simplely replace BetterSpinner with MaterialBetterSpinner.

## Download
I'm still working on push BetterSpinner to Maven Central.

## Acknowledgements
Thanks my girlfriend Wanrong(wt263@msstate.edu) for the icon :)

Thanks [Matt](https://github.com/mattblang) for his inspiration

[MaterialEditText](https://github.com/rengwuxian/MaterialEditText)


## License

    Copyright 2015 Wei Wang

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
