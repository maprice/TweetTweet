# TweetTweet

is an android app that allows a user to view his Twitter timeline and post a new tweet. The app utilizes [Twitter REST API](https://dev.twitter.com/rest/public).

Time spent: 20 hours spent in total

## User Stories

The following **required** functionality is completed:

* [x]	User can **sign in to Twitter** using OAuth login
* [x]	User can **view tweets from their home timeline**
* [x] User is displayed the username, name, and body for each tweet
* [x] User is displayed the [relative timestamp](https://gist.github.com/nesquena/f786232f5ef72f6e10a7) for each tweet "8m", "7h"
* [x] User can view more tweets as they scroll with [infinite pagination](http://guides.codepath.com/android/Endless-Scrolling-with-AdapterViews-and-RecyclerView). Number of tweets is unlimited.
However there are [Twitter Api Rate Limits](https://dev.twitter.com/rest/public/rate-limiting) in place.
* [x] User can **compose and post a new tweet**
* [x] User can click a “Compose” icon in floating action button
* [x] User can then enter a new tweet and post this to twitter
* [x] User is taken back to home timeline with **new tweet visible** in timeline

The following **optional** features are implemented:

* [x] User can **see a counter with total number of characters left for tweet** on compose tweet page
* [x] User can **click a link within a tweet body** on tweet details view. The click will launch the web browser with relevant page opened.
* [x] User can **pull down to refresh tweets timeline**
* [x] User can **open the twitter app offline and see last loaded tweets**. Persisted in SQLite tweets are refreshed on every application launch. While "live data" is displayed when app can get it from Twitter API, it is also saved for use in offline mode.
* [x] User can tap a tweet to **open a detailed tweet view**
* [x] User can **select "reply" from detail view to respond to a tweet**
* [x] Improve the user interface and theme the app to feel "twitter branded"

The following **bonus** features are implemented:

* [x] User can see embedded image media within the tweet detail view
* [ ] User can watch embedded video within the tweet
* [x] Compose tweet functionality is build using modal overlay
* [ ] Use Parcelable instead of Serializable using the popular [Parceler library](http://guides.codepath.com/android/Using-Parceler).
* [x] Apply the popular [Butterknife annotation library](http://guides.codepath.com/android/Reducing-View-Boilerplate-with-Butterknife) to reduce view boilerplate.
* [ ] Leverage the popular [GSON library](http://guides.codepath.com/android/Using-Android-Async-Http-Client#decoding-with-gson-library) to streamline the parsing of JSON data.
* [x] [Leverage RecyclerView](http://guides.codepath.com/android/Using-the-RecyclerView) as a replacement for the ListView and ArrayAdapter for all lists of tweets.
* [x] Move the "Compose" action to a [FloatingActionButton](https://github.com/codepath/android_guides/wiki/Floating-Action-Buttons) instead of on the AppBar.
* [x] Replace Picasso with [Glide](http://inthecheesefactory.com/blog/get-to-know-glide-recommended-by-google/en) for more efficient image rendering.

The following **additional** features are implemented:

- [x] Scrolling animations: arcticles smoothly fade into view when scrolling.
- [x] Splash Screen
- [x] Image loading placeholder:  Display default loading image while downloading image
- [x] User can favorite tweets
- [x] User can retweet tweets
- [x] Fetches current user data to get profile image and name
- [x] Makes use of shared preferences to store application wide username and profileURL data

## Video Walkthrough 

### Basic user flow
![Alt text](/images/demo_smooth.gif)

### Too Many characters
![Alt text](/images/too_many_chars.gif)

### Auth Screen
![Alt text](/images/o_auth.gif)

### No network connection
![Alt text](/images/nonetwork.gif)

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Picasso](http://square.github.io/picasso/) - Image loading and caching library for Android
- [ButterKnife](http://jakewharton.github.io/butterknife/) Annotation library to reduce view boilerplate
- [Glide](https://github.com/bumptech/glide) Image downloading and caching library 
- [RecyclerView Animators](https://github.com/wasabeef/recyclerview-animators) RecyclerView Animiations
- [Prettytime](http://www.ocpsoft.org/prettytime/) Timestamp formatting
- [RoundedImageView](https://github.com/vinc3m1/RoundedImageView) It's like an ImageView, only rounder

### Images
- [Icons8](https://icons8.com/android-icons/) Icons

### Notes
- Could improve on offline experience, ability to Tweet offline, and send once network connection is established.
- Better UI when offline, somthing more permanent than a toast
- Need stratedy for deleting old tweets. (Only keep 100 newest?)

License
--------

    Copyright 2016 Mike Price.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
