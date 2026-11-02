package com.example.data

import com.example.model.CourseLevelId
import com.example.model.DialogueLine
import com.example.model.Lesson
import com.example.model.LessonSection
import com.example.model.QuestionType
import com.example.model.QuizQuestion
import com.example.model.WordExample

object CourseData {

    val allLessons: List<Lesson> = listOf(
        // LEVEL 1: ABSOLUTE BEGINNER
        Lesson(
            id = "l1_1",
            levelId = CourseLevelId.LEVEL_1,
            number = 1,
            titleEn = "Introduction to Korean & Hangul",
            titleFil = "Panimula sa Korean at Hangul",
            titleKo = "한글과 한국어 소개",
            descriptionEn = "Learn the history, structure, and brilliance of Hangul created by King Sejong the Great.",
            descriptionFil = "Alamin ang kasaysayan at ganda ng Hangul na nilikha ni Haring Sejong ang Dakila.",
            sections = listOf(
                LessonSection.Introduction(
                    headingEn = "Welcome to Hangul (한글)!",
                    headingFil = "Maligayang pagdating sa Hangul (한글)!",
                    contentEn = "Hangul was created in 1443 by King Sejong the Great. Unlike Chinese characters, Korean Hangul is a scientific phonetic alphabet designed so that anyone can learn to read it in just a few days! Letters represent the shapes of the vocal organs when speaking.",
                    contentFil = "Nilikha ang Hangul noong 1443 ni Haring Sejong the Great. Di tulad ng mga karakter ng Tsino, ang Hangul ay isang siyentipikong alpabetong ponetiko na madaling matutunan ng kahit sino sa loob ng ilang araw! Ang mga hugis ay hango sa posisyon ng bibig at dila."
                ),
                LessonSection.GrammarPoint(
                    titleEn = "Syllable Block Structure",
                    titleFil = "Kayarian ng Pantig",
                    pattern = "Initial Consonant + Vowel (+ Final Batchim)",
                    explanationEn = "Korean words are written in square syllable blocks. Each block has at least 1 consonant and 1 vowel. If a syllable starts with a vowel sound, the silent letter 'ㅇ' is used as a placeholder.",
                    explanationFil = "Ang mga salitang Korean ay isinusulat sa parisukat na pantig. Bawat pantig ay may 1 katinig at 1 patinig. Kapag nagsisimula sa patinig, ginagamit ang 'ㅇ' bilang walang-tunog na panimula.",
                    examples = listOf(
                        WordExample("아", "a", "Placeholder ㅇ + vowel ㅏ", "Walang-tunog na ㅇ + patinig na ㅏ"),
                        WordExample("가", "ga", "Consonant ㄱ + vowel ㅏ", "Katinig na ㄱ + patinig na ㅏ"),
                        WordExample("한", "han", "Consonant ㅎ + vowel ㅏ + batchim ㄴ", "Katinig na ㅎ + patinig ㅏ + dulo ㄴ")
                    )
                ),
                LessonSection.CultureTip(
                    titleEn = "King Sejong's Vision",
                    titleFil = "Ang Hangarin ni Haring Sejong",
                    textEn = "King Sejong wanted every commoner to be literate so they could express their thoughts and defend their rights. Korea celebrates 'Hangul Day' every October 9th!",
                    textFil = "Nais ni Haring Sejong na ang bawat karaniwang mamamayan ay marunong magbasa at magsulat upang maipahayag ang kanilang damdamin. Ipinagdiriwang ang Hangul Day tuwing Oktubre 9!"
                )
            ),
            quiz = listOf(
                QuizQuestion(
                    id = "q_l1_1_1",
                    type = QuestionType.MULTIPLE_CHOICE,
                    promptEn = "Who created the Korean writing system, Hangul?",
                    promptFil = "Sino ang lumikha ng sistema ng pagsulat ng Korean na Hangul?",
                    options = listOf("King Sejong the Great", "General Yi Sun-sin", "King Taejo", "Gwanggaeto the Great"),
                    correctAnswer = "King Sejong the Great",
                    explanationEn = "King Sejong the Great invented Hangul in 1443 to increase literacy among the common people.",
                    explanationFil = "Nilikha ni Haring Sejong the Great ang Hangul noong 1443 upang makapagbasa ang lahat."
                ),
                QuizQuestion(
                    id = "q_l1_1_2",
                    type = QuestionType.MULTIPLE_CHOICE,
                    promptEn = "What does the letter 'ㅇ' do when placed at the beginning of a syllable block like '아'?",
                    promptFil = "Ano ang gamit ng letrang 'ㅇ' kapag nasa unahan ng pantig tulad ng '아'?",
                    options = listOf("Acts as a silent placeholder", "Sounds like 'ng'", "Sounds like 'm'", "Makes the vowel longer"),
                    correctAnswer = "Acts as a silent placeholder",
                    explanationEn = "'ㅇ' is completely silent at the start of a syllable, allowing the vowel sound to be pronounced alone.",
                    explanationFil = "Ang 'ㅇ' ay walang tunog sa simula ng pantig at nagsisilbing placeholder lamang."
                )
            )
        ),

        Lesson(
            id = "l1_2",
            levelId = CourseLevelId.LEVEL_1,
            number = 2,
            titleEn = "Korean Greetings & Etiquette",
            titleFil = "Pagbati at Kaugaliang Korean",
            titleKo = "한국어 인사와 예절",
            descriptionEn = "Master polite greetings: Annyeonghaseyo, Gamsahamnida, and proper bowing etiquette.",
            descriptionFil = "Matutunan ang magagalang na pagbati: Annyeonghaseyo, Gamsahamnida, at pagyuko.",
            sections = listOf(
                LessonSection.Introduction(
                    headingEn = "Greetings in Korean Culture",
                    headingFil = "Kahalagahan ng Pagbati",
                    contentEn = "Politeness is paramount in Korean culture. Whenever greeting elders or people you meet, bowing slightly while saying '안녕하세요' (Annyeonghaseyo) shows deep respect.",
                    contentFil = "Napakataas ng pagpapahalaga sa paggalang sa kulturang Korean. Ang marahang pagyuko habang binibigkas ang '안녕하세요' (Annyeonghaseyo) ay tanda ng respeto."
                ),
                LessonSection.Dialogue(
                    titleEn = "Meeting for the First Time",
                    titleFil = "Unang Pagkikita",
                    lines = listOf(
                        DialogueLine("Mina", "안녕하세요! 저는 미나예요.", "Annyeonghaseyo! Jeoneun Minayeyo.", "Hello! I am Mina.", "Kumusta po! Ako po si Mina."),
                        DialogueLine("Juan", "안녕하세요! 만나서 반갑습니다.", "Annyeonghaseyo! Mannaseo bangapsumnida.", "Hello! Nice to meet you.", "Kumusta po! Ikinagagalak ko po kayong makilala.")
                    )
                ),
                LessonSection.GrammarPoint(
                    titleEn = "Polite vs Formal Goodbye",
                    titleFil = "Paalam Kapag Ikaw o Sila ang Aalis",
                    pattern = "안녕히 가세요 (Go in peace) vs 안녕히 계세요 (Stay in peace)",
                    explanationEn = "If you are leaving while the other person stays, say '안녕히 계세요' (Stay well). If the other person is leaving, say '안녕히 가세요' (Go well).",
                    explanationFil = "Kapag ikaw ang aalis at maiiwan sila, sabihin ang '안녕히 계세요'. Kapag sila naman ang aalis, sabihin ang '안녕히 가세요'.",
                    examples = listOf(
                        WordExample("안녕히 계세요", "Annyeonghi gyeseyo", "Stay peacefully (to person staying)", "Maiiwan po kayo nang payapa"),
                        WordExample("안녕히 가세요", "Annyeonghi gaseyo", "Go peacefully (to person leaving)", "Ingat po sa inyong pag-alis")
                    )
                )
            ),
            quiz = listOf(
                QuizQuestion(
                    id = "q_l1_2_1",
                    type = QuestionType.TRANSLATION,
                    promptKr = "안녕하세요",
                    promptEn = "What does '안녕하세요' mean?",
                    promptFil = "Ano ang kahulugan ng '안녕하세요'?",
                    audioText = "안녕하세요",
                    options = listOf("Hello / Good day", "Goodbye", "Thank you", "Excuse me"),
                    correctAnswer = "Hello / Good day",
                    explanationEn = "안녕하세요 (Annyeonghaseyo) is the universal polite Korean greeting.",
                    explanationFil = "Ang 안녕하세요 ay ang karaniwang magalang na pagbati sa Korea."
                ),
                QuizQuestion(
                    id = "q_l1_2_2",
                    type = QuestionType.MULTIPLE_CHOICE,
                    promptEn = "You are leaving a shop. What should you say to the shopkeeper who is staying?",
                    promptFil = "Aalis ka na sa tindahan. Ano ang sasabihin mo sa tindera na maiiwan?",
                    options = listOf("안녕히 계세요", "안녕히 가세요", "죄송합니다", "실례합니다"),
                    correctAnswer = "안녕히 계세요",
                    explanationEn = "Use '안녕히 계세요' (Stay in peace) when speaking to someone who is staying behind.",
                    explanationFil = "Gamitin ang '안녕히 계세요' kapag ang kausap mo ay maiiwan sa lugar."
                )
            )
        ),

        Lesson(
            id = "l1_3",
            levelId = CourseLevelId.LEVEL_1,
            number = 3,
            titleEn = "Introducing Yourself (자기소개)",
            titleFil = "Pagpapakilala sa Sarili",
            titleKo = "자기소개하기",
            descriptionEn = "Learn to say your name, nationality, and polite phrases: 저는 ~예요/이에요.",
            descriptionFil = "Sabihin ang iyong pangalan, nasyonalidad, at magalang na hulapi.",
            sections = listOf(
                LessonSection.Introduction(
                    headingEn = "Saying Who You Are",
                    headingFil = "Pagsasabi ng Iyong Pagkakakilanlan",
                    contentEn = "To introduce yourself, say '저는 [Name]이에요/예요' (I am [Name]). Use '이에요' after a consonant ending, and '예요' after a vowel ending.",
                    contentFil = "Para magpakilala, sabihin ang '저는 [Pangalan]이에요/예요' (Ako po si [Pangalan]). Gamitin ang '이에요' kapag nagtatapos sa katinig, at '예요' kapag patinig."
                ),
                LessonSection.Dialogue(
                    titleEn = "Self Introduction",
                    titleFil = "Pakikipagkilala",
                    lines = listOf(
                        DialogueLine("Carlo", "안녕하세요! 저는 카를로예요.", "Annyeonghaseyo! Jeoneun Kareulloyeyo.", "Hello! I am Carlo.", "Kumusta po! Ako po si Carlo."),
                        DialogueLine("Carlo", "저는 필리핀 사람이에요.", "Jeoneun Pilripin saram-ieyo.", "I am Filipino.", "Ako po ay Pilipino."),
                        DialogueLine("Soo-jin", "반가워요, 카를로 씨!", "Bangawoyo, Kareullo ssi!", "Nice to meet you, Carlo!", "Ikinagagalak kitang makilala, Carlo!")
                    )
                ),
                LessonSection.GrammarPoint(
                    titleEn = "Topic Marker: 은 / 는",
                    titleFil = "Pantukoy sa Paksa: 은 / 는",
                    pattern = "Noun + 은 (consonant) / 는 (vowel)",
                    explanationEn = "'저는' means 'As for me / I'. 저 (me) ends in a vowel, so it takes '는'.",
                    explanationFil = "Ang '저는' ay nangangahulugang 'Kung ako naman / Ako'. Ang '저' ay nagtatapos sa patinig kaya sinusundan ng '는'.",
                    examples = listOf(
                        WordExample("저는 필리핀 사람이에요.", "Jeoneun pillipin saram-ieyo.", "I am Filipino.", "Ako ay Pilipino."),
                        WordExample("이름은 무엇이에요?", "Ireum-eun mueot-ieyo?", "What is your name?", "Ano po ang inyong pangalan?")
                    )
                )
            ),
            quiz = listOf(
                QuizQuestion(
                    id = "q_l1_3_1",
                    type = QuestionType.SENTENCE_BUILD,
                    promptEn = "Build the sentence: 'I am Filipino.'",
                    promptFil = "Buuin ang pangungusap: 'Ako po ay Pilipino.'",
                    options = listOf("저는", "필리핀", "사람이에요"),
                    correctAnswer = "저는 필리핀 사람이에요",
                    explanationEn = "Korean word order: Subject (저는) + Nationality (필리핀 사람) + Verb (이에요).",
                    explanationFil = "Ayos ng pangungusap sa Korean: Simuno (저는) + Lahi (필리핀 사람) + Pandiwa (이에요)."
                )
            )
        ),

        // LEVEL 2: EVERYDAY KOREAN
        Lesson(
            id = "l2_1",
            levelId = CourseLevelId.LEVEL_2,
            number = 1,
            titleEn = "Essential Particles: 은/는, 이/가, 을/를",
            titleFil = "Mahahalagang Kataga: 은/는, 이/가, 을/를",
            titleKo = "기본 조사 마스터하기",
            descriptionEn = "Master subject, topic, and object markers that hold Korean sentences together.",
            descriptionFil = "Pag-aralan ang mga katagang nag-uugnay sa simuno, paksa, at layon.",
            sections = listOf(
                LessonSection.Introduction(
                    headingEn = "Why Particles Matter in Korean",
                    headingFil = "Kahalagahan ng mga Kataga sa Korean",
                    contentEn = "Korean is an SOV (Subject - Object - Verb) language. Particles attached to nouns clarify the exact role of each word in the sentence.",
                    contentFil = "Ang wikang Korean ay sumusunod sa ayos na Simuno - Layon - Pandiwa. Ang mga kataga (particles) ang nagsasabi kung ano ang ginagawa ng bawat salita."
                ),
                LessonSection.GrammarPoint(
                    titleEn = "Object Marker: 을 / 를",
                    titleFil = "Pantukoy sa Layon: 을 / 를",
                    pattern = "Noun + 을 (after consonant) / 를 (after vowel)",
                    explanationEn = "Attach 을/를 to whatever receives the action of the verb.",
                    explanationFil = "Ikabit ang 을/를 sa salitang tumatanggap ng kilos ng pandiwa.",
                    examples = listOf(
                        WordExample("물을 마셔요", "Mul-eul masyeoyo", "I drink water", "Umiinom ako ng tubig"),
                        WordExample("사과를 먹어요", "Sagwa-reul meogeoyo", "I eat an apple", "Kumakain ako ng mansanas")
                    )
                )
            ),
            quiz = listOf(
                QuizQuestion(
                    id = "q_l2_1_1",
                    type = QuestionType.MULTIPLE_CHOICE,
                    promptEn = "Complete the phrase: '밥___ 먹어요' (I eat rice)",
                    promptFil = "Punan ang patlang: '밥___ 먹어요' (Kumakain ng kanin)",
                    options = listOf("을", "를", "는", "가"),
                    correctAnswer = "을",
                    explanationEn = "'밥' ends with the batchim consonant ㅂ, so it takes the object particle '을'.",
                    explanationFil = "Ang '밥' ay nagtatapos sa katinig na ㅂ kaya '을' ang tamang kataga."
                )
            )
        ),

        // LEVEL 3: PRACTICAL KOREAN IN SOUTH KOREA
        Lesson(
            id = "l3_1",
            levelId = CourseLevelId.LEVEL_3,
            number = 1,
            titleEn = "At the Subway & Bus Station",
            titleFil = "Sa Istasyon ng Subway at Bus",
            titleKo = "지하철과 버스 타기",
            descriptionEn = "Navigate Seoul metro, top up T-Money cards, and ask for stops confidently.",
            descriptionFil = "Sumakay sa Seoul subway, mag-load ng T-Money card, at magtanong ng babaan.",
            sections = listOf(
                LessonSection.Introduction(
                    headingEn = "Riding South Korea's Public Transit",
                    headingFil = "Pagsakay sa Transportasyon sa Korea",
                    contentEn = "South Korea has one of the cleanest and fastest public transit networks in the world. You use a rechargeable T-Money card to tap in and tap out.",
                    contentFil = "Napakabilis at napakalinis ng pampublikong sasakyan sa South Korea. T-Money card ang ginagamit sa pagpasok at paglabas ng istasyon."
                ),
                LessonSection.Dialogue(
                    titleEn = "Buying and Loading a T-Money Card",
                    titleFil = "Pagbili at Pag-load ng T-Money",
                    lines = listOf(
                        DialogueLine("Traveler", "교통카드 있어요?", "Gyotongkadeu isseoyo?", "Do you have a transit card?", "Mayroon po ba kayong transit card?"),
                        DialogueLine("Clerk", "네, 여기 있습니다.", "Ne, yeogi itsseumnida.", "Yes, here it is.", "Opo, narito po."),
                        DialogueLine("Traveler", "만원 충전해 주세요.", "Manwon chungjeonhae juseyo.", "Please load 10,000 won.", "Paki-loadan po ng 10,000 won.")
                    )
                )
            ),
            quiz = listOf(
                QuizQuestion(
                    id = "q_l3_1_1",
                    type = QuestionType.MULTIPLE_CHOICE,
                    promptEn = "How do you ask 'Where is the subway station?' in Korean?",
                    promptFil = "Paano itanong sa Korean ang 'Nasaan ang istasyon ng subway?'",
                    options = listOf("지하철역이 어디예요?", "얼마예요?", "화장실이 어디예요?", "버스 정류장이에요?"),
                    correctAnswer = "지하철역이 어디예요?",
                    explanationEn = "지하철역 (Subway station) + 이 어디예요? (Where is it?).",
                    explanationFil = "지하철역 (istasyon ng subway) + 이 어디예요? (Nasaan po?)."
                )
            )
        ),

        Lesson(
            id = "l3_2",
            levelId = CourseLevelId.LEVEL_3,
            number = 2,
            titleEn = "Ordering at Korean Restaurants",
            titleFil = "Pag-order sa Kainan at Restawran",
            titleKo = "식당에서 주문하기",
            descriptionEn = "Order famous dishes, ask for water, call the server: '저기요!', '물 주세요!'.",
            descriptionFil = "Mag-order ng pagkain, humingi ng tubig, at tumawag ng serbidor: '저기요!', '물 주세요!'.",
            sections = listOf(
                LessonSection.Introduction(
                    headingEn = "Dining Out in Korea",
                    headingFil = "Pagkain sa mga Restawran sa Korea",
                    contentEn = "At Korean restaurants, you can press the call bell on your table or raise your hand and politely say '저기요!' (Excuse me / Over here!). Side dishes (반찬) and water are almost always complimentary!",
                    contentFil = "Sa mga restawran sa Korea, may bell sa lamesa o sabihin lamang ang magalang na '저기요!' (Makikiraan po / Dito po!). Libre at libreng dagdag ang mga banchan at tubig!"
                ),
                LessonSection.Dialogue(
                    titleEn = "Ordering Lunch",
                    titleFil = "Pag-order ng Tanghalian",
                    lines = listOf(
                        DialogueLine("Customer", "저기요! 비빔밥 하나, 불고기 하나 주세요.", "Jeogiyo! Bibimbap hana, bulgogi hana juseyo.", "Excuse me! One bibimbap and one bulgogi, please.", "Makikiraan po! Isang bibimbap at isang bulgogi po, pakiusap."),
                        DialogueLine("Server", "네, 알겠습니다. 물은 셀프입니다.", "Ne, algetseumnida. Mul-eun selpeu-imnida.", "Yes, understood. Water is self-service.", "Opo, masusunod po. Kayo na po ang kukuha ng tubig (self-service).")
                    )
                )
            ),
            quiz = listOf(
                QuizQuestion(
                    id = "q_l3_2_1",
                    type = QuestionType.MULTIPLE_CHOICE,
                    promptEn = "What is the polite phrase used to call a waiter in a restaurant?",
                    promptFil = "Ano ang magalang na sinasabi para tawagin ang serbidor sa restawran?",
                    options = listOf("저기요!", "야!", "안녕!", "죄송해요!"),
                    correctAnswer = "저기요!",
                    explanationEn = "'저기요!' literally means 'Over there!', used universally and politely to get service attention.",
                    explanationFil = "Ang '저기요!' ang pamantayan at magalang na tawag sa serbidor."
                )
            )
        ),

        // LEVEL 4: INTERMEDIATE FOUNDATIONS
        Lesson(
            id = "l4_1",
            levelId = CourseLevelId.LEVEL_4,
            number = 1,
            titleEn = "Giving Reasons using -아서 / -어서",
            titleFil = "Pagsasabi ng Dahilan gamit ang -아서 / -어서",
            titleKo = "이유를 나타내는 -아서/-어서",
            descriptionEn = "Connect cause and effect: 'Because I was tired, I slept early.'",
            descriptionFil = "Pag-ugnayin ang sanhi at bunga gamit ang -아서/-어서.",
            sections = listOf(
                LessonSection.Introduction(
                    headingEn = "Expressing Cause & Effect",
                    headingFil = "Sanhi at Bunga",
                    contentEn = "To say 'because' or 'so', conjugate the first verb with -아서 (for bright vowels ㅏ, ㅗ) or -어서 (for other vowels).",
                    contentFil = "Para sabihin ang 'dahil' o 'kaya', ikabit ang -아서 o -어서 sa unang pandiwa bago ang resulta."
                ),
                LessonSection.GrammarPoint(
                    titleEn = "Reason Structure",
                    titleFil = "Kayarian ng Dahilan",
                    pattern = "Verb stem + 아서 / 어서",
                    explanationEn = "피곤하다 (tired) -> 피곤해서 (because I am tired).",
                    explanationFil = "피곤하다 (pagod) -> 피곤해서 (dahil pagod ako).",
                    examples = listOf(
                        WordExample("배가 고파서 밥을 먹었어요.", "Baega gopaseo babeul meogeosseoyo.", "Because I was hungry, I ate food.", "Dahil nagugutom ako, kumain ako ng kanin.")
                    )
                )
            ),
            quiz = listOf(
                QuizQuestion(
                    id = "q_l4_1_1",
                    type = QuestionType.TRANSLATION,
                    promptKr = "배가 고파서 밥을 먹었어요.",
                    promptEn = "What does this sentence mean?",
                    promptFil = "Ano ang kahulugan ng pangungusap na ito?",
                    options = listOf(
                        "Because I was hungry, I ate food.",
                        "I am eating delicious food.",
                        "Where is the restaurant?",
                        "I want to drink cold water."
                    ),
                    correctAnswer = "Because I was hungry, I ate food.",
                    explanationEn = "배가 고프다 (hungry) + 아서 (because) -> ate meal.",
                    explanationFil = "Dahil gutom kaya kumain ng pagkain."
                )
            )
        )
    )

    fun getLessonsForLevel(levelId: CourseLevelId): List<Lesson> {
        return allLessons.filter { it.levelId == levelId }
    }
}
