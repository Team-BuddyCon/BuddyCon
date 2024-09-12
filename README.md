# BuddyCon
A service that allows you to add your own gifticons and manage them in one place or customize them and share them with your friends.

![2D](https://github.com/user-attachments/assets/05e6d27f-6920-49c5-aa5a-6b8e5a239f32)

<br>

## Download
Go to the [Release](https://play.google.com/store/apps/details?id=com.yapp.buddycon&hl=ko) to download the latest APK. <br>
But, the service was terminated due to lack of server maintenance.

<br>

## Tech stack & Open-source libraries
- Min SDK 26
- Kotlin based, Coroutines + Flow for asynchronous.
- Jetpack
  - Lifecycle
  - ViewModel
  - Room
  - ViewBinding
  - Hilt
  - DataStore
  - Navigation
  - Splashscreen
- Retrofit2 & OkHttp3 & Gson
- Firebase Remote Config
- 3rd party library
  - Kakao
  - MLKit
  - Zxing

<br>

## Architecture
BuddyCon is based on a clean architecture, and the presentation applies the MVVM pattern. 
It is divided into modules accordingly.

![buddycon architecture drawio](https://github.com/user-attachments/assets/5018d07a-46cf-484a-9288-4df6df39674e)

- Dependency Management : buildSrc
- Presentation : UI & presentation logic
- Domain : repository & entity
- Data : business logic

<br>

## Kakao login 
![무제 drawio](https://github.com/user-attachments/assets/8f54ca64-58ba-4509-9bde-5a97c713473c)

- During JWT authentication, when accessToken expires, renewal logic processed as refreshToken in Interceptor

<br>

# License
```
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
