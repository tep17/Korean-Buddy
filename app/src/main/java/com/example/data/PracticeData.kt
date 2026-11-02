package com.example.data

import com.example.model.ConversationChoice
import com.example.model.ConversationSimulation
import com.example.model.ConversationStep
import com.example.model.QuestionType
import com.example.model.QuizQuestion

object PracticeData {

    val conversations = listOf(
        ConversationSimulation(
            id = "conv_restaurant",
            titleEn = "At a Traditional Restaurant in Seoul",
            titleFil = "Sa Tradisyunal na Restawran sa Seoul",
            location = "Gwangjang Market, Seoul",
            scenarioEn = "You enter a lively restaurant and need to ask for a seat, water, and order food.",
            scenarioFil = "Pumasok ka sa masiglang restawran at kailangan mong magtanong ng upuan, humingi ng tubig, at mag-order.",
            steps = listOf(
                ConversationStep(
                    speaker = "Staff",
                    koreanPrompt = "어서오세요! 몇 분이세요?",
                    romanization = "Eoseooseyo! Myeot bun-iseyo?",
                    meaningEn = "Welcome! How many people are in your party?",
                    meaningFil = "Maligayang pagdating po! Ilang tao po kayo?",
                    choices = listOf(
                        ConversationChoice(
                            korean = "한 명이에요.",
                            romanization = "Han myeong-ieyo.",
                            meaningEn = "Just one person.",
                            meaningFil = "Isang tao lamang po.",
                            isBest = true,
                            explanationEn = "Proper counting of people using Native Korean number '하나' -> '한' + counter '명'.",
                            explanationFil = "Tamang pagbibilang ng tao gamit ang katutubong bilang '한' + tagabilang na '명'."
                        ),
                        ConversationChoice(
                            korean = "일 명이에요.",
                            romanization = "Il myeong-ieyo.",
                            meaningEn = "One person (Incorrect number system)",
                            meaningFil = "Isang tao (Maling sistema ng numero)",
                            isBest = false,
                            explanationEn = "Do not use Sino-Korean '일' when counting people with '명'. Use Native '한'.",
                            explanationFil = "Huwag gamitin ang Sino-Korean na '일' para sa bilang ng tao. Gamitin ang '한'."
                        ),
                        ConversationChoice(
                            korean = "얼마예요?",
                            romanization = "Eolmayeyo?",
                            meaningEn = "How much is it?",
                            meaningFil = "Magkano po ito?",
                            isBest = false,
                            explanationEn = "The server asked how many people, not how much it costs.",
                            explanationFil = "Tinanong kung ilang tao kayo, hindi kung magkano."
                        )
                    )
                ),
                ConversationStep(
                    speaker = "Staff",
                    koreanPrompt = "여기 앉으세요. 무엇을 드릴까요?",
                    romanization = "Yeogi anjeuseyo. Mueos-eul deurilkkayo?",
                    meaningEn = "Please sit here. What would you like to order?",
                    meaningFil = "Maupo po kayo rito. Ano po ang maipaglilingkod ko?",
                    choices = listOf(
                        ConversationChoice(
                            korean = "비빔밥 하나 주세요. 그리고 물도 주세요.",
                            romanization = "Bibimbap hana juseyo. Geurigo muldo juseyo.",
                            meaningEn = "One bibimbap, please. And please give me water too.",
                            meaningFil = "Isang bibimbap po, pakiusap. At pahingi rin po ng tubig.",
                            isBest = true,
                            explanationEn = "Polite and natural request using '주세요' (please give me).",
                            explanationFil = "Magalang at natural na paghiling gamit ang '주세요'."
                        ),
                        ConversationChoice(
                            korean = "화장실이 어디예요?",
                            romanization = "Hwajangsil-i eodiyeyo?",
                            meaningEn = "Where is the restroom?",
                            meaningFil = "Nasaan ang banyo?",
                            isBest = false,
                            explanationEn = "You can ask this later, but first answer the server's order question.",
                            explanationFil = "Maaari mo itong itanong mamaya, ngunit sagutin muna ang order."
                        )
                    )
                )
            )
        ),

        ConversationSimulation(
            id = "conv_cafe",
            titleEn = "Ordering Iced Coffee at a Cafe",
            titleFil = "Pag-order ng Iced Coffee sa Kapehan",
            location = "Hongdae Cafe, Seoul",
            scenarioEn = "Experience ordering the famous Korean 'Ah-Ah' (Iced Americano) at a busy cafe.",
            scenarioFil = "Subukang mag-order ng tanyag na 'Ah-Ah' (Iced Americano) sa kapehan sa Korea.",
            steps = listOf(
                ConversationStep(
                    speaker = "Barista",
                    koreanPrompt = "주문 도와드리겠습니다. 드시고 가시나요?",
                    romanization = "Jumun dowadeurigetsseumnida. Deusigo gasinayo?",
                    meaningEn = "I can help you order. For here or to-go?",
                    meaningFil = "Handa na po akong kumuha ng order. Dito po ba iinumin o take-out?",
                    choices = listOf(
                        ConversationChoice(
                            korean = "테이크아웃 할게요. 아이스 아메리카노 한 잔 주세요.",
                            romanization = "Teikeu-aut halgeyo. Aiseu Amerikano han jan juseyo.",
                            meaningEn = "To-go, please. One iced Americano, please.",
                            meaningFil = "Take-out po. Isang iced Americano po, pakiusap.",
                            isBest = true,
                            explanationEn = "Clear and natural choice specifying to-go and item count.",
                            explanationFil = "Malinaw at natural na pagsasabi kung take-out at dami ng baso."
                        ),
                        ConversationChoice(
                            korean = "안녕히 가세요.",
                            romanization = "Annyeonghi gaseyo.",
                            meaningEn = "Goodbye.",
                            meaningFil = "Paalam po.",
                            isBest = false,
                            explanationEn = "You just started ordering! Don't say goodbye yet.",
                            explanationFil = "Kakasimula pa lang mag-order! Huwag munang magpaalam."
                        )
                    )
                ),
                ConversationStep(
                    speaker = "Barista",
                    koreanPrompt = "4,500원입니다. 결제는 어떻게 도와드릴까요?",
                    romanization = "Sacheon-obaek-won-imnida. Gyeoljeneun eotteoke dowadeurilkkayo?",
                    meaningEn = "That is 4,500 won. How would you like to pay?",
                    meaningFil = "4,500 won po. Paano po ninyo gustong magbayad?",
                    choices = listOf(
                        ConversationChoice(
                            korean = "카드로 할게요.",
                            romanization = "Kadeuro halgeyo.",
                            meaningEn = "I will pay with card.",
                            meaningFil = "Magbabayad po ako gamit ang card.",
                            isBest = true,
                            explanationEn = "Most cafes in Korea prefer cashless/credit card payment.",
                            explanationFil = "Karamihan sa mga kapehan sa Korea ay mas gusto ang card."
                        ),
                        ConversationChoice(
                            korean = "비싸요!",
                            romanization = "Bissayo!",
                            meaningEn = "It is expensive!",
                            meaningFil = "Napakamahal!",
                            isBest = false,
                            explanationEn = "4,500 won is standard coffee pricing in Seoul.",
                            explanationFil = "Karaniwang presyo ng kape sa Seoul ang 4,500 won."
                        )
                    )
                )
            )
        )
    )

    val dailyChallengeQuestions = listOf(
        // Vocab 1
        QuizQuestion(
            id = "dc_v1",
            type = QuestionType.MULTIPLE_CHOICE,
            promptKr = "물",
            promptEn = "What does '물' mean?",
            promptFil = "Ano ang ibig sabihin ng '물'?",
            audioText = "물",
            options = listOf("Water", "Fire", "Rice", "Door"),
            correctAnswer = "Water",
            explanationEn = "물 (mul) means water in Korean.",
            explanationFil = "Ang '물' ay tubig sa wikang Korean."
        ),
        // Vocab 2
        QuizQuestion(
            id = "dc_v2",
            type = QuestionType.TRANSLATION,
            promptKr = "감사합니다",
            promptEn = "Choose the correct English meaning for '감사합니다':",
            promptFil = "Piliin ang wastong kahulugan sa Tagalog ng '감사합니다':",
            audioText = "감사합니다",
            options = listOf("Thank you (Formal)", "I am sorry", "Hello", "Goodbye"),
            correctAnswer = "Thank you (Formal)",
            explanationEn = "감사합니다 (Gamsahamnida) is the polite formal expression for Thank you.",
            explanationFil = "Ang 감사합니다 ay ang magalang at pormal na paraan ng pagsasabi ng 'Salamat po'."
        ),
        // Hangul 1
        QuizQuestion(
            id = "dc_h1",
            type = QuestionType.HANGUL_RECOGNITION,
            promptKr = "ㄱ",
            promptEn = "Identify the approximate pronunciation of 'ㄱ':",
            promptFil = "Tukuyin ang wastong tunog ng 'ㄱ':",
            audioText = "기역",
            options = listOf("g / k", "m", "s", "d / t"),
            correctAnswer = "g / k",
            explanationEn = "ㄱ (giyeok) produces a soft 'g' initially and 'k' in batchim.",
            explanationFil = "Ang ㄱ (giyeok) ay may tunog na g / k."
        ),
        // Hangul 2
        QuizQuestion(
            id = "dc_h2",
            type = QuestionType.HANGUL_RECOGNITION,
            promptKr = "ㅏ",
            promptEn = "What sound does the basic vowel 'ㅏ' make?",
            promptFil = "Anong tunog ang nalilikha ng patinig na 'ㅏ'?",
            audioText = "아",
            options = listOf("a (ah)", "u (oo)", "o (oh)", "i (ee)"),
            correctAnswer = "a (ah)",
            explanationEn = "ㅏ sounds like open 'ah' as in 'father'.",
            explanationFil = "Ang ㅏ ay tunog 'a' tulad sa 'araw'."
        ),
        // Listening 1
        QuizQuestion(
            id = "dc_l1",
            type = QuestionType.LISTENING,
            promptKr = "밥",
            promptEn = "Listen to the audio and select the matching Korean word:",
            promptFil = "Pakinggan ang audio at piliin ang katugmang salita sa Korean:",
            audioText = "밥",
            options = listOf("밥 (bap)", "방 (bang)", "발 (bal)", "밤 (bam)"),
            correctAnswer = "밥 (bap)",
            explanationEn = "밥 (bap) means cooked rice or meal.",
            explanationFil = "Ang 밥 (bap) ay kanin o pagkain."
        ),
        // Word Arrange
        QuizQuestion(
            id = "dc_w1",
            type = QuestionType.WORD_ARRANGE,
            promptEn = "Arrange the syllables to form the Korean word for 'School':",
            promptFil = "Ayusin ang mga pantig upang mabuo ang salitang 'Paaralan':",
            options = listOf("학", "교"),
            correctAnswer = "학교",
            explanationEn = "학 (hak) + 교 (gyo) = 학교 (hakgyo - School).",
            explanationFil = "학 (hak) + 교 (gyo) = 학교 (paaralan).",
            arrangeTiles = listOf("교", "학")
        ),
        // Sentence Builder
        QuizQuestion(
            id = "dc_s1",
            type = QuestionType.SENTENCE_BUILD,
            promptEn = "Form the polite sentence: 'Please give me water.'",
            promptFil = "Buuin ang magalang na pangungusap: 'Pahingi po ng tubig.'",
            options = listOf("물", "주세요"),
            correctAnswer = "물 주세요",
            explanationEn = "물 (water) + 주세요 (please give me).",
            explanationFil = "물 (tubig) + 주세요 (pahingi po).",
            arrangeTiles = listOf("주세요", "물")
        )
    )
}
