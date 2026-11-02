# 🇰🇷 Korean Buddy: Learn Korean

Interactive Android application built with **Jetpack Compose**, **Kotlin**, **Material 3**, and **Room Database**. Designed especially for English and Filipino (Tagalog) speakers who want to read, write, listen to, and speak Korean.

---

## 📲 Direct APK Download

Download the latest APK directly on your Android phone:

👉 **[Download Latest KoreanBuddy-debug.apk](https://github.com/tep17/Korean-Buddy/releases/download/latest/KoreanBuddy-debug.apk)**

> **Note:** If you are downloading for the first time on Android, tap the downloaded `.apk` file and allow **"Install unknown apps"** when prompted in your browser or file manager settings.

---

## ✨ Key Features

- **Trilingual Learning System**: Switch between **English**, **Filipino (Tagalog)**, and **Korean (Immersion)** at any time.
- **Hangul Alphabet Studio**:
  - 14 Basic Consonants & 5 Double Consonants
  - 10 Basic Vowels & 11 Compound Vowels
  - Pronunciation tips, mouth/tongue position guides, stroke order, and audio pronunciation.
- **Interactive Syllable Builder**:
  - Dynamically combines Initial Consonants (초성), Vowels (중성), and Final Consonants (받침) in real time with Korean speech audio.
- **Batchim (받침) Guide**:
  - Covers the 7 representative sounds (`[k]`, `[n]`, `[t]`, `[l]`, `[m]`, `[p]`, `[ng]`) with authentic examples.
- **4-Level Structured Course**:
  - **Level 1**: Absolute Beginner (Hangul, Greetings & Basics)
  - **Level 2**: Everyday Korean (Particles 은/는, 이/가, 을/를, Polite Endings)
  - **Level 3**: Practical South Korea (Subway, Cafes, Restaurants, Emergencies)
  - **Level 4**: Intermediate Foundations (Reasoning -아서/-어서, Complex Sentences)
- **Practice Hub**:
  - Conversation Dialogues (Restaurant & Hongdae Cafe simulations)
  - Spaced Repetition Flashcards (Easy / Good / Difficult algorithm)
  - Daily Challenge with scorecards
  - Sentence Builder and Syllable arrangement
  - Review Weak Areas (tracks previously missed questions)
- **100% Offline Support**:
  - Local SQLite / Room Database saves your study streaks, completed lessons, quiz accuracy, and favorite vocabulary.
- **Korean Audio Pronunciation**:
  - Built-in Text-To-Speech with a **0.65x slow-mode toggle** for beginner clarity.

---

## 🛠️ Building From Source

```bash
# Clone the repository
git clone https://github.com/tep17/Korean-Buddy.git
cd Korean-Buddy

# Build debug APK
./gradlew assembleDebug

# Output location:
# app/build/outputs/apk/debug/app-debug.apk
```

---

## 🚀 Automated CI/CD
Every commit pushed to the repository automatically triggers the **GitHub Actions** workflow (`.github/workflows/build-apk.yml`) to build the APK and upload it to the **Releases** tab for one-click downloading.
