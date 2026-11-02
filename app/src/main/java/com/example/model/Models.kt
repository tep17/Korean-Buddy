package com.example.model

enum class LearningLanguage(
    val code: String,
    val displayName: String,
    val flag: String,
    val localizedGreeting: String
) {
    ENGLISH("en", "English", "🇺🇸", "Welcome to Korean Buddy!"),
    FILIPINO("fil", "Filipino (Tagalog)", "🇵🇭", "Maligayang pagdating sa Korean Buddy!"),
    KOREAN("ko", "한국어 (Immersion)", "🇰🇷", "코리안 버디에 오신 것을 환영합니다!")
}

enum class HangulCategory(val titleEn: String, val titleFil: String) {
    BASIC_CONSONANT("Basic Consonants (14)", "Mga Payak na Katinig (14)"),
    DOUBLE_CONSONANT("Double Consonants (5)", "Kambal-Katinig (5)"),
    BASIC_VOWEL("Basic Vowels (10)", "Mga Payak na Patinig (10)"),
    COMPOUND_VOWEL("Compound Vowels (11)", "Tambalang Patinig (11)")
}

data class WordExample(
    val korean: String,
    val romanization: String,
    val english: String,
    val filipino: String
)

data class HangulCharacter(
    val char: String,
    val name: String,
    val category: HangulCategory,
    val englishSound: String,
    val filipinoSound: String,
    val englishExplanation: String,
    val filipinoExplanation: String,
    val mouthTipEn: String,
    val mouthTipFil: String,
    val strokeCount: Int,
    val strokeGuide: List<String>,
    val exampleSyllables: List<String>,
    val exampleWords: List<WordExample>
)

data class BatchimRule(
    val title: String,
    val characters: String,
    val representativeSound: String,
    val explanationEn: String,
    val explanationFil: String,
    val examples: List<WordExample>
)

enum class CourseLevelId(val titleEn: String, val titleFil: String, val subtitle: String) {
    LEVEL_1("Level 1: Absolute Beginner", "Antas 1: Baguhan", "Hangul, Greetings & Basics"),
    LEVEL_2("Level 2: Everyday Korean", "Antas 2: Pang-araw-araw", "Particles, Conjugations & Life"),
    LEVEL_3("Level 3: Practical Korea", "Antas 3: Praktikal sa Korea", "Travel, Subway, Work & Dining"),
    LEVEL_4("Level 4: Intermediate Foundations", "Antas 4: Gitnang Antas", "Complex Grammar & Dialogues")
}

data class Lesson(
    val id: String,
    val levelId: CourseLevelId,
    val number: Int,
    val titleEn: String,
    val titleFil: String,
    val titleKo: String,
    val descriptionEn: String,
    val descriptionFil: String,
    val estimatedMinutes: Int = 8,
    val sections: List<LessonSection>,
    val quiz: List<QuizQuestion>
)

sealed class LessonSection {
    data class Introduction(
        val headingEn: String,
        val headingFil: String,
        val contentEn: String,
        val contentFil: String
    ) : LessonSection()

    data class Dialogue(
        val titleEn: String,
        val titleFil: String,
        val lines: List<DialogueLine>
    ) : LessonSection()

    data class VocabularyList(
        val items: List<VocabularyItem>
    ) : LessonSection()

    data class GrammarPoint(
        val titleEn: String,
        val titleFil: String,
        val pattern: String,
        val explanationEn: String,
        val explanationFil: String,
        val examples: List<WordExample>
    ) : LessonSection()

    data class CultureTip(
        val titleEn: String,
        val titleFil: String,
        val textEn: String,
        val textFil: String
    ) : LessonSection()
}

data class DialogueLine(
    val speaker: String,
    val korean: String,
    val romanization: String,
    val english: String,
    val filipino: String
)

enum class QuestionType {
    MULTIPLE_CHOICE,
    TRANSLATION,
    HANGUL_RECOGNITION,
    LISTENING,
    WORD_ARRANGE,
    SENTENCE_BUILD
}

data class QuizQuestion(
    val id: String,
    val type: QuestionType,
    val promptKr: String? = null,
    val promptEn: String,
    val promptFil: String,
    val audioText: String? = null,
    val options: List<String>,
    val correctAnswer: String,
    val explanationEn: String,
    val explanationFil: String,
    val arrangeTiles: List<String> = emptyList()
)

enum class VocabCategory(val titleEn: String, val titleFil: String, val titleKo: String, val icon: String) {
    ALPHABET_SYLLABLES("Alphabet & Syllables", "Alpabeto at Pantig", "한글과 음절", "🔤"),
    GREETINGS("Greetings", "Pagbati", "인사", "👋"),
    NUMBERS("Numbers", "Mga Numero", "숫자", "🔢"),
    FOOD_DRINKS("Food & Drinks", "Pagkain at Inumin", "음식과 음료", "🍲"),
    TRANSPORTATION("Transportation", "Transportasyon", "교통", "🚇"),
    SHOPPING("Shopping", "Pamimili", "쇼핑", "🛍️"),
    DIRECTIONS("Directions", "Direksyon", "길찾기", "🧭"),
    FAMILY("Family", "Pamilya", "가족", "👨‍👩‍👧"),
    TIME_DATES("Time & Dates", "Oras at Petsa", "시간과 날짜", "⏰"),
    WORKPLACE("Workplace", "Lugar ng Trabaho", "직장", "💼"),
    TRAVEL("Travel", "Paglalakbay", "여행", "✈️"),
    EMERGENCY("Emergency Phrases", "Mga Parirala sa Sakuna", "비상 표현", "🚨"),
    VERBS("Everyday Verbs", "Pang-araw-araw na Pandiwa", "일상 동사", "🏃"),
    ADJECTIVES("Common Adjectives", "Pang-uri", "형용사", "✨")
}

data class VocabularyItem(
    val id: String,
    val korean: String,
    val romanization: String,
    val english: String,
    val filipino: String,
    val pronunciationTip: String,
    val exampleKr: String,
    val exampleEn: String,
    val exampleFil: String,
    val category: VocabCategory,
    val difficulty: String = "Beginner",
    val isFavorite: Boolean = false,
    val srsLevel: Int = 0
)

data class ConversationSimulation(
    val id: String,
    val titleEn: String,
    val titleFil: String,
    val location: String,
    val scenarioEn: String,
    val scenarioFil: String,
    val steps: List<ConversationStep>
)

data class ConversationStep(
    val speaker: String,
    val koreanPrompt: String,
    val romanization: String,
    val meaningEn: String,
    val meaningFil: String,
    val choices: List<ConversationChoice>
)

data class ConversationChoice(
    val korean: String,
    val romanization: String,
    val meaningEn: String,
    val meaningFil: String,
    val isBest: Boolean,
    val explanationEn: String,
    val explanationFil: String
)

data class Achievement(
    val id: String,
    val titleEn: String,
    val titleFil: String,
    val descEn: String,
    val descFil: String,
    val iconEmoji: String,
    val isUnlocked: Boolean,
    val progress: Float
)
