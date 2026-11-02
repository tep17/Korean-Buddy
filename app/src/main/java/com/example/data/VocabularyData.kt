package com.example.data

import com.example.model.VocabCategory
import com.example.model.VocabularyItem

object VocabularyData {

    val items = listOf(
        // ==========================================
        // 1. ALPHABET & SYLLABLES (한글과 음절)
        // ==========================================
        VocabularyItem(
            id = "v_alpha_1",
            korean = "한글",
            romanization = "Hangeul",
            english = "Hangul (The Korean Alphabet)",
            filipino = "Hangul (Alpabetong Koreano)",
            pronunciationTip = "Han-geul",
            exampleKr = "한글을 배우는 것은 재미있어요.",
            exampleEn = "Learning Hangul is fun.",
            exampleFil = "Napakasayang mag-aral ng Hangul.",
            category = VocabCategory.ALPHABET_SYLLABLES,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_alpha_2",
            korean = "자음",
            romanization = "Jaeum",
            english = "Consonant",
            filipino = "Katinig",
            pronunciationTip = "Ja-eum",
            exampleKr = "한글에는 기본 자음이 14개 있습니다.",
            exampleEn = "Hangul has 14 basic consonants.",
            exampleFil = "Mayroong 14 na payak na katinig sa Hangul.",
            category = VocabCategory.ALPHABET_SYLLABLES,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_alpha_3",
            korean = "모음",
            romanization = "Moeum",
            english = "Vowel",
            filipino = "Patinig",
            pronunciationTip = "Mo-eum",
            exampleKr = "한글 모음은 하늘, 땅, 사람을 나타냅니다.",
            exampleEn = "Hangul vowels represent sky, earth, and human.",
            exampleFil = "Ang mga patinig ng Hangul ay kumakatawan sa langit, lupa, at tao.",
            category = VocabCategory.ALPHABET_SYLLABLES,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_alpha_4",
            korean = "받침",
            romanization = "Batchim",
            english = "Final Consonant (Bottom consonant)",
            filipino = "Panghuling Katinig (Katinig sa ilalim ng pantig)",
            pronunciationTip = "Bat-cheem",
            exampleKr = "‘한국’에서 ‘ㄱ’은 받침이에요.",
            exampleEn = "In 'Hanguk', 'ㄱ' is the batchim.",
            exampleFil = "Sa salitang 'Hanguk', ang 'ㄱ' ay ang batchim.",
            category = VocabCategory.ALPHABET_SYLLABLES,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_alpha_5",
            korean = "음절",
            romanization = "Eumjeol",
            english = "Syllable block",
            filipino = "Pantig",
            pronunciationTip = "Eum-jeol",
            exampleKr = "한글은 음절 단위로 모아씁니다.",
            exampleEn = "Hangul is written gathered in syllable blocks.",
            exampleFil = "Ang Hangul ay isinusulat nang naka-pangkat sa bawat pantig.",
            category = VocabCategory.ALPHABET_SYLLABLES,
            difficulty = "Intermediate"
        ),
        VocabularyItem(
            id = "v_alpha_6",
            korean = "발음",
            romanization = "Bareum",
            english = "Pronunciation",
            filipino = "Pagbigkas / Tunog",
            pronunciationTip = "Bah-reum",
            exampleKr = "한국어 발음이 아주 좋아요.",
            exampleEn = "Your Korean pronunciation is very good.",
            exampleFil = "Napakaganda ng iyong pagbigkas sa wikang Koreano.",
            category = VocabCategory.ALPHABET_SYLLABLES,
            difficulty = "Beginner"
        ),

        // ==========================================
        // 2. GREETINGS & COURTESY (인사와 예절)
        // ==========================================
        VocabularyItem(
            id = "v_greet_1",
            korean = "안녕하세요",
            romanization = "Annyeonghaseyo",
            english = "Hello / Good day (Polite)",
            filipino = "Kumusta po (Magalang)",
            pronunciationTip = "An-nyeong-ha-se-yo",
            exampleKr = "안녕하세요, 만나서 반갑습니다.",
            exampleEn = "Hello, nice to meet you.",
            exampleFil = "Kumusta po, ikinagagalak ko kayong makilala.",
            category = VocabCategory.GREETINGS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_greet_2",
            korean = "감사합니다",
            romanization = "Gamsahamnida",
            english = "Thank you (Formal)",
            filipino = "Salamat po (Pormal)",
            pronunciationTip = "Gam-sa-ham-ni-da",
            exampleKr = "도와주셔서 정말 감사합니다.",
            exampleEn = "Thank you very much for helping.",
            exampleFil = "Maraming salamat po sa pagtulong.",
            category = VocabCategory.GREETINGS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_greet_3",
            korean = "죄송합니다",
            romanization = "Joesonghamnida",
            english = "I am sorry (Formal)",
            filipino = "Patawad po / Pasensya na po",
            pronunciationTip = "Joe-song-ham-ni-da",
            exampleKr = "늦어서 죄송합니다.",
            exampleEn = "I am sorry for being late.",
            exampleFil = "Pasensya na po at nahuli ako.",
            category = VocabCategory.GREETINGS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_greet_4",
            korean = "안녕히 계세요",
            romanization = "Annyeonghi gyeseyo",
            english = "Goodbye (When you leave, other person stays)",
            filipino = "Paalam po (Kapag ikaw ang aalis at maiiwan sila)",
            pronunciationTip = "An-nyeong-hi gye-se-yo",
            exampleKr = "먼저 가겠습니다. 안녕히 계세요!",
            exampleEn = "I will go first. Goodbye!",
            exampleFil = "Mauuna na po ako. Paalam po!",
            category = VocabCategory.GREETINGS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_greet_5",
            korean = "안녕히 가세요",
            romanization = "Annyeonghi gaseyo",
            english = "Goodbye (When other person leaves)",
            filipino = "Ingat po sa pag-alis (Kapag sila ang aalis)",
            pronunciationTip = "An-nyeong-hi ga-se-yo",
            exampleKr = "조심히 가세요. 안녕히 가세요!",
            exampleEn = "Go safely. Goodbye!",
            exampleFil = "Mag-ingat po kayo sa daan. Paalam!",
            category = VocabCategory.GREETINGS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_greet_6",
            korean = "실례합니다",
            romanization = "Sillyehamnida",
            english = "Excuse me (Formal)",
            filipino = "Mawalang-galang na po / Makikiraan",
            pronunciationTip = "Sil-lye-ham-ni-da",
            exampleKr = "실례합니다, 길 좀 묻겠습니다.",
            exampleEn = "Excuse me, may I ask for directions?",
            exampleFil = "Makikiraan po, maaari po bang magtanong ng daan?",
            category = VocabCategory.GREETINGS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_greet_7",
            korean = "네 / 아니요",
            romanization = "Ne / Aniyo",
            english = "Yes / No",
            filipino = "Opo / Hindi po",
            pronunciationTip = "Ne / A-ni-yo",
            exampleKr = "네, 맞아요. / 아니요, 괜찮아요.",
            exampleEn = "Yes, that is right. / No, it's okay.",
            exampleFil = "Opo, tama po iyan. / Hindi po, ayos lang.",
            category = VocabCategory.GREETINGS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_greet_8",
            korean = "처음 뵙겠습니다",
            romanization = "Cheoeum boepgetseumnida",
            english = "Nice to meet you (First encounter formal)",
            filipino = "Ikinagagalak ko kayong makilala sa unang pagkakataon",
            pronunciationTip = "Cheo-eum boep-get-seum-ni-da",
            exampleKr = "처음 뵙겠습니다. 잘 부탁드립니다.",
            exampleEn = "Nice to meet you. Please treat me well.",
            exampleFil = "Ikinagagalak ko kayong makilala. Nawa'y magkasundo tayo nang maayos.",
            category = VocabCategory.GREETINGS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_greet_9",
            korean = "잘 지냈어요?",
            romanization = "Jal jinaesseoyo?",
            english = "How have you been?",
            filipino = "Kumusta ka na? / Maayos ka ba?",
            pronunciationTip = "Jal jee-naess-eo-yo?",
            exampleKr = "오랜만이에요! 그동안 잘 지냈어요?",
            exampleEn = "Long time no see! How have you been in the meantime?",
            exampleFil = "Matagal na tayong hindi nagkita! Kumusta ka naman nitong mga nakaraan?",
            category = VocabCategory.GREETINGS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_greet_10",
            korean = "수고하셨습니다",
            romanization = "Sugohasyeotseumnida",
            english = "Thank you for your hard work (At end of job/day)",
            filipino = "Salamat po sa inyong pagsisikap at trabaho",
            pronunciationTip = "Soo-go-ha-syeot-seum-ni-da",
            exampleKr = "오늘 하루도 모두 수고하셨습니다!",
            exampleEn = "Great work today everyone!",
            exampleFil = "Salamat po sa inyong sipag ngayong araw!",
            category = VocabCategory.GREETINGS,
            difficulty = "Intermediate"
        ),
        VocabularyItem(
            id = "v_greet_11",
            korean = "축하합니다",
            romanization = "Chukhahamnida",
            english = "Congratulations!",
            filipino = "Maligayang pagbati! / Binabati kita!",
            pronunciationTip = "Choo-ka-ham-ni-da",
            exampleKr = "생일을 진심으로 축하합니다!",
            exampleEn = "Happy Birthday from the bottom of my heart!",
            exampleFil = "Maligayang kaarawan mula sa kaibuturan ng aking puso!",
            category = VocabCategory.GREETINGS,
            difficulty = "Beginner"
        ),

        // ==========================================
        // 3. NUMBERS (숫자)
        // ==========================================
        VocabularyItem(
            id = "v_num_1",
            korean = "하나, 둘, 셋, 넷, 다섯",
            romanization = "Hana, Dul, Set, Net, Daseot",
            english = "1, 2, 3, 4, 5 (Native Korean - for counting objects & people)",
            filipino = "1, 2, 3, 4, 5 (Katutubong Koreano - para sa gamit at tao)",
            pronunciationTip = "Ha-na, Dool, Set, Net, Da-seot",
            exampleKr = "사과 하나, 물 두 개 주세요.",
            exampleEn = "One apple and two bottles of water, please.",
            exampleFil = "Isang mansanas at dalawang bote ng tubig po.",
            category = VocabCategory.NUMBERS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_num_2",
            korean = "여섯, 일곱, 여덟, 아홉, 열",
            romanization = "Yeoseot, Ilgop, Yeodeol, Ahop, Yeol",
            english = "6, 7, 8, 9, 10 (Native Korean)",
            filipino = "6, 7, 8, 9, 10 (Katutubong Koreano)",
            pronunciationTip = "Yeo-seot, Eel-gop, Yeo-deol, Ah-hop, Yeol",
            exampleKr = "열 명이 함께 식사했어요.",
            exampleEn = "Ten people had a meal together.",
            exampleFil = "Sampung tao ang sabay-sabay na kumain.",
            category = VocabCategory.NUMBERS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_num_3",
            korean = "스물, 서른, 마흔, 쉰",
            romanization = "Seumul, Seoreun, Maheun, Swin",
            english = "20, 30, 40, 50 (Native Korean - for age)",
            filipino = "20, 30, 40, 50 (Katutubong Koreano - para sa edad)",
            pronunciationTip = "Seu-mool, Seo-reun, Ma-heun, Sween",
            exampleKr = "저는 올해 스물다섯 살이에요.",
            exampleEn = "I am twenty-five years old this year.",
            exampleFil = "Dalawampu't limang taong gulang na ako ngayong taon.",
            category = VocabCategory.NUMBERS,
            difficulty = "Intermediate"
        ),
        VocabularyItem(
            id = "v_num_4",
            korean = "일, 이, 삼, 사, 오",
            romanization = "Il, I, Sam, Sa, O",
            english = "1, 2, 3, 4, 5 (Sino-Korean - for money, phone & minutes)",
            filipino = "1, 2, 3, 4, 5 (Sino-Korean - para sa pera, telepono at minuto)",
            pronunciationTip = "Eel, Ee, Sahm, Sah, Oh",
            exampleKr = "삼천 원입니다.",
            exampleEn = "It is 3,000 Won.",
            exampleFil = "3,000 Won po ito.",
            category = VocabCategory.NUMBERS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_num_5",
            korean = "육, 칠, 팔, 구, 십",
            romanization = "Yuk, Chil, Pal, Gu, Sip",
            english = "6, 7, 8, 9, 10 (Sino-Korean)",
            filipino = "6, 7, 8, 9, 10 (Sino-Korean)",
            pronunciationTip = "Yook, Cheel, Pahl, Goo, Sheep",
            exampleKr = "십 분만 기다려 주세요.",
            exampleEn = "Please wait just ten minutes.",
            exampleFil = "Maghintay po lamang ng sampung minuto.",
            category = VocabCategory.NUMBERS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_num_6",
            korean = "백, 천, 만, 십만, 백만",
            romanization = "Baek, Cheon, Man, Simman, Baekman",
            english = "100, 1,000, 10,000, 100,000, 1,000,000",
            filipino = "100, 1,000, 10,000, 100,000, 1,000,000 (Malalaking Bilang)",
            pronunciationTip = "Baek, Cheon, Mahn, Shim-man, Baek-man",
            exampleKr = "이 가방은 오만 원이에요.",
            exampleEn = "This bag is 50,000 won.",
            exampleFil = "Ang bag na ito ay 50,000 won.",
            category = VocabCategory.NUMBERS,
            difficulty = "Intermediate"
        ),

        // ==========================================
        // 4. FOOD & DRINKS (음식과 음료)
        // ==========================================
        VocabularyItem(
            id = "v_food_1",
            korean = "물",
            romanization = "Mul",
            english = "Water",
            filipino = "Tubig",
            pronunciationTip = "Mool",
            exampleKr = "시원한 물 주세요.",
            exampleEn = "Please give me cold water.",
            exampleFil = "Pahingi po ng malamig na tubig.",
            category = VocabCategory.FOOD_DRINKS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_food_2",
            korean = "밥",
            romanization = "Bap",
            english = "Cooked rice / Meal",
            filipino = "Kanin / Pagkain",
            pronunciationTip = "Bop",
            exampleKr = "밥 먹었어요?",
            exampleEn = "Did you eat? (Common Korean greeting)",
            exampleFil = "Kumain ka na ba? (Karaniwang pagbati)",
            category = VocabCategory.FOOD_DRINKS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_food_3",
            korean = "김치",
            romanization = "Gimchi",
            english = "Kimchi (fermented cabbage/radish)",
            filipino = "Kimchi (fermentadong gulay)",
            pronunciationTip = "Gim-chee",
            exampleKr = "김치 더 주세요.",
            exampleEn = "Please give me more kimchi.",
            exampleFil = "Pahingi pa po ng karagdagang kimchi.",
            category = VocabCategory.FOOD_DRINKS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_food_4",
            korean = "삼겹살",
            romanization = "Samgyeopsal",
            english = "Grilled pork belly",
            filipino = "Inihaw na liempo ng baboy",
            pronunciationTip = "Sam-gyeop-sal",
            exampleKr = "오늘 저녁에 삼겹살 먹으러 가요.",
            exampleEn = "Let's go eat samgyeopsal for dinner tonight.",
            exampleFil = "Tayo nang kumain ng samgyeopsal para sa hapunan mamaya.",
            category = VocabCategory.FOOD_DRINKS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_food_5",
            korean = "떡볶이",
            romanization = "Tteokbokki",
            english = "Spicy rice cakes",
            filipino = "Maanghang na rice cake",
            pronunciationTip = "Tteok-bok-kee",
            exampleKr = "포장마차에서 떡볶이를 먹었어요.",
            exampleEn = "I ate tteokbokki at a street food tent.",
            exampleFil = "Kumain ako ng tteokbokki sa tindahan sa tabi ng kalsada.",
            category = VocabCategory.FOOD_DRINKS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_food_6",
            korean = "비빔밥",
            romanization = "Bibimbap",
            english = "Bibimbap (Mixed rice with vegetables)",
            filipino = "Bibimbap (Pinaghalong kanin, karne, at gulay)",
            pronunciationTip = "Bee-beem-bap",
            exampleKr = "돌솥 비빔밥이 아주 뜨거워요.",
            exampleEn = "The stone-pot bibimbap is very hot.",
            exampleFil = "Napakainit ng bibimbap na nasa mangkok na bato.",
            category = VocabCategory.FOOD_DRINKS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_food_7",
            korean = "라면",
            romanization = "Ramyeon",
            english = "Instant noodles / Ramen",
            filipino = "Ramen / Noodles",
            pronunciationTip = "Rah-myeon",
            exampleKr = "한강 공원에서 끓인 라면이 최고예요.",
            exampleEn = "Ramyeon cooked at Han River park is the best.",
            exampleFil = "Ang pinakamasarap na ramen ay niluluto sa tabi ng Han River.",
            category = VocabCategory.FOOD_DRINKS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_food_8",
            korean = "치킨 & 맥주 (치맥)",
            romanization = "Chimaek",
            english = "Korean fried chicken and beer",
            filipino = "Pritong manok at serbesa",
            pronunciationTip = "Chee-maek",
            exampleKr = "금요일 밤에는 치맥이 생각나요.",
            exampleEn = "I think of chicken and beer on Friday nights.",
            exampleFil = "Masarap mag-chimaek tuwing Biyernes ng gabi.",
            category = VocabCategory.FOOD_DRINKS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_food_9",
            korean = "덜 맵게 해주세요",
            romanization = "Deol maepge haejuseyo",
            english = "Please make it less spicy",
            filipino = "Pakiusap, huwag po masyadong maanghang",
            pronunciationTip = "Deol maep-ge hae-joo-se-yo",
            exampleKr = "매운 걸 못 먹어서 덜 맵게 해주세요.",
            exampleEn = "I cannot eat spicy food, so please make it less spicy.",
            exampleFil = "Hindi po ako marunong kumain ng maanghang kaya pakiusap huwag masyadong maanghang.",
            category = VocabCategory.FOOD_DRINKS,
            difficulty = "Intermediate"
        ),
        VocabularyItem(
            id = "v_food_10",
            korean = "계산서 주세요",
            romanization = "Gyesanseo juseyo",
            english = "Please give me the bill / check",
            filipino = "Paki-abot po ng bill / bayarin",
            pronunciationTip = "Gye-san-seo joo-se-yo",
            exampleKr = "여기 계산서 좀 갖다 주세요.",
            exampleEn = "Please bring the bill over here.",
            exampleFil = "Paki-abot po rito ng aming bill.",
            category = VocabCategory.FOOD_DRINKS,
            difficulty = "Beginner"
        ),

        // ==========================================
        // 5. TRANSPORTATION (교통)
        // ==========================================
        VocabularyItem(
            id = "v_trans_1",
            korean = "지하철",
            romanization = "Jihacheol",
            english = "Subway / Metro",
            filipino = "Tren sa ilalim ng lupa / Subway",
            pronunciationTip = "Jee-ha-cheol",
            exampleKr = "지하철역이 어디예요?",
            exampleEn = "Where is the subway station?",
            exampleFil = "Nasaan po ang istasyon ng subway?",
            category = VocabCategory.TRANSPORTATION,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_trans_2",
            korean = "버스 정류장",
            romanization = "Beoseu jeongnyujang",
            english = "Bus stop",
            filipino = "Sakayan / Hinto ng bus",
            pronunciationTip = "Buh-seu jeong-nyu-jang",
            exampleKr = "가장 가까운 버스 정류장이 어디인가요?",
            exampleEn = "Where is the nearest bus stop?",
            exampleFil = "Nasaan po ang pinakamalapit na hintuan ng bus?",
            category = VocabCategory.TRANSPORTATION,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_trans_3",
            korean = "택시",
            romanization = "Taeksi",
            english = "Taxi",
            filipino = "Taksi",
            pronunciationTip = "Taek-shee",
            exampleKr = "명동까지 택시로 얼마나 걸려요?",
            exampleEn = "How long does it take to Myeongdong by taxi?",
            exampleFil = "Gaano katagal bago makarating sa Myeongdong kapag nag-taksi?",
            category = VocabCategory.TRANSPORTATION,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_trans_4",
            korean = "기차 / KTX",
            romanization = "Gicha / KTX",
            english = "Train / High-Speed Bullet Train",
            filipino = "Tren / KTX (Mabilis na tren ng Korea)",
            pronunciationTip = "Gee-cha / KTX",
            exampleKr = "KTX를 타면 부산까지 2시간 반 걸려요.",
            exampleEn = "If you take KTX, it takes 2.5 hours to Busan.",
            exampleFil = "Kapag sumakay ng KTX, 2 oras at kalahati lang papuntang Busan.",
            category = VocabCategory.TRANSPORTATION,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_trans_5",
            korean = "교통카드 충전",
            romanization = "Gyotongkadeu chungjeon",
            english = "Transit card top-up (T-Money load)",
            filipino = "Pag-load sa transport card (T-Money)",
            pronunciationTip = "Gyo-tong-ka-deu choong-jeon",
            exampleKr = "편의점에서 교통카드 충전할 수 있어요.",
            exampleEn = "You can top up your transit card at convenience stores.",
            exampleFil = "Maaari mong loadan ang iyong transit card sa mga convenience store.",
            category = VocabCategory.TRANSPORTATION,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_trans_6",
            korean = "갈아타다 (환승)",
            romanization = "Garatada (Hwanseung)",
            english = "To transfer / Switch lines",
            filipino = "Lumipat ng linya o sasakyan (Transfer)",
            pronunciationTip = "Gah-rah-tah-da",
            exampleKr = "시청역에서 2호선으로 갈아타세요.",
            exampleEn = "Transfer to Line 2 at City Hall Station.",
            exampleFil = "Lumipat sa Line 2 pagdating sa City Hall Station.",
            category = VocabCategory.TRANSPORTATION,
            difficulty = "Intermediate"
        ),
        VocabularyItem(
            id = "v_trans_7",
            korean = "출구 / 입구",
            romanization = "Chulgu / Ipgu",
            english = "Exit / Entrance",
            filipino = "Labasan / Pasukan",
            pronunciationTip = "Chool-goo / Eep-goo",
            exampleKr = "3번 출구 앞에서 만나요.",
            exampleEn = "Let's meet in front of Exit 3.",
            exampleFil = "Magkita tayo sa harap ng Exit 3.",
            category = VocabCategory.TRANSPORTATION,
            difficulty = "Beginner"
        ),

        // ==========================================
        // 6. SHOPPING (쇼핑)
        // ==========================================
        VocabularyItem(
            id = "v_shop_1",
            korean = "얼마예요?",
            romanization = "Eolmayeyo?",
            english = "How much is it?",
            filipino = "Magkano po ito?",
            pronunciationTip = "Eol-ma-ye-yo?",
            exampleKr = "이거 얼마예요?",
            exampleEn = "How much is this?",
            exampleFil = "Magkano po ba ito?",
            category = VocabCategory.SHOPPING,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_shop_2",
            korean = "할인 / 세일",
            romanization = "Harin / Seil",
            english = "Discount / Sale",
            filipino = "Tapyas sa presyo / Bawas / Sale",
            pronunciationTip = "Hah-reen / Seh-eel",
            exampleKr = "지금 20% 할인하고 있어요.",
            exampleEn = "It is currently 20% off.",
            exampleFil = "May bawas na 20% ngayon.",
            category = VocabCategory.SHOPPING,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_shop_3",
            korean = "입어봐도 돼요?",
            romanization = "Ibeobwado dwaeyo?",
            english = "Can I try this on?",
            filipino = "Maaari ko po bang isukat ito?",
            pronunciationTip = "Ee-beo-bwa-do dwae-yo?",
            exampleKr = "저 옷 입어봐도 돼요?",
            exampleEn = "Can I try on those clothes over there?",
            exampleFil = "Pwede ko po bang isukat ang damit na iyon?",
            category = VocabCategory.SHOPPING,
            difficulty = "Intermediate"
        ),
        VocabularyItem(
            id = "v_shop_4",
            korean = "봉투 필요하세요?",
            romanization = "Bongtu piryohaseyo?",
            english = "Do you need a shopping bag?",
            filipino = "Kailangan niyo po ba ng supot?",
            pronunciationTip = "Bong-too pee-ryo-ha-se-yo?",
            exampleKr = "네, 종이 봉투 하나 주세요.",
            exampleEn = "Yes, please give me one paper bag.",
            exampleFil = "Opo, paki-bigyan po ako ng isang paper bag.",
            category = VocabCategory.SHOPPING,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_shop_5",
            korean = "교환 / 환불",
            romanization = "Gyohwan / Hwanbul",
            english = "Exchange / Refund",
            filipino = "Pagpapalit / Pagbabalik ng pera (Refund)",
            pronunciationTip = "Gyo-hwan / Hwan-bool",
            exampleKr = "영수증이 있으면 일주일 내에 환불 가능해요.",
            exampleEn = "If you have the receipt, refunds are possible within a week.",
            exampleFil = "Maaaring mag-refund sa loob ng isang linggo kung may resibo.",
            category = VocabCategory.SHOPPING,
            difficulty = "Intermediate"
        ),
        VocabularyItem(
            id = "v_shop_6",
            korean = "카드 돼요?",
            romanization = "Kadeu dwaeyo?",
            english = "Do you accept credit card?",
            filipino = "Tumatanggap po ba kayo ng card?",
            pronunciationTip = "Ka-deu dwae-yo?",
            exampleKr = "체크카드 결제 돼요?",
            exampleEn = "Can I pay with a debit card?",
            exampleFil = "Maaari po bang magbayad gamit ang debit card?",
            category = VocabCategory.SHOPPING,
            difficulty = "Beginner"
        ),

        // ==========================================
        // 7. DIRECTIONS (길찾기)
        // ==========================================
        VocabularyItem(
            id = "v_dir_1",
            korean = "화장실이 어디예요?",
            romanization = "Hwajangsil-i eodiyeyo?",
            english = "Where is the restroom?",
            filipino = "Nasaan po ang banyo?",
            pronunciationTip = "Hwa-jang-shil-ee eo-di-ye-yo?",
            exampleKr = "저기요, 화장실이 어디예요?",
            exampleEn = "Excuse me, where is the restroom?",
            exampleFil = "Makikiraan po, nasaan po ang banyo?",
            category = VocabCategory.DIRECTIONS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_dir_2",
            korean = "직진하세요",
            romanization = "Jikjinhaseyo",
            english = "Go straight ahead",
            filipino = "Dumeretso lang po",
            pronunciationTip = "Jeek-jeen-ha-se-yo",
            exampleKr = "이 길로 100미터 직진하세요.",
            exampleEn = "Go straight 100 meters along this street.",
            exampleFil = "Dumeretso po ng 100 metro sa daang ito.",
            category = VocabCategory.DIRECTIONS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_dir_3",
            korean = "오른쪽 / 왼쪽",
            romanization = "Oreunjjok / Oenjjok",
            english = "Right side / Left side",
            filipino = "Kanan / Kaliwa",
            pronunciationTip = "O-reun-jjok / Oen-jjok",
            exampleKr = "사거리에서 오른쪽으로 도세요.",
            exampleEn = "Turn right at the intersection.",
            exampleFil = "Kumanan po kayo sa may kanto.",
            category = VocabCategory.DIRECTIONS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_dir_4",
            korean = "건너편 (맞은편)",
            romanization = "Geonneopyeon",
            english = "Across the street / Opposite side",
            filipino = "Sa kabilang ibayo ng kalsada",
            pronunciationTip = "Geon-neo-pyeon",
            exampleKr = "은행 건너편에 약국이 있어요.",
            exampleEn = "There is a pharmacy across from the bank.",
            exampleFil = "May botika sa tapat ng bangko.",
            category = VocabCategory.DIRECTIONS,
            difficulty = "Intermediate"
        ),
        VocabularyItem(
            id = "v_dir_5",
            korean = "엘리베이터 / 계단",
            romanization = "Ellibeiteo / Gyedan",
            english = "Elevator / Stairs",
            filipino = "Elebitor / Hagdan",
            pronunciationTip = "El-lee-beh-ee-teo / Gye-dan",
            exampleKr = "무거운 짐이 있으면 엘리베이터를 이용하세요.",
            exampleEn = "If you have heavy luggage, please use the elevator.",
            exampleFil = "Kung mabigat ang inyong bagahe, gamitin po ang elebitor.",
            category = VocabCategory.DIRECTIONS,
            difficulty = "Beginner"
        ),

        // ==========================================
        // 8. FAMILY (가족)
        // ==========================================
        VocabularyItem(
            id = "v_fam_1",
            korean = "아버지 / 어머니",
            romanization = "Abeoji / Eomeoni",
            english = "Father / Mother (Polite)",
            filipino = "Tatay / Nanay (Magalang)",
            pronunciationTip = "Ah-beo-jee / Eo-meo-nee",
            exampleKr = "부모님께 항상 감사드려요.",
            exampleEn = "I am always thankful to my parents.",
            exampleFil = "Lagi akong nagpapasalamat sa aking mga magulang.",
            category = VocabCategory.FAMILY,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_fam_2",
            korean = "오빠 / 언니",
            romanization = "Oppa / Eonni",
            english = "Older brother / Older sister (Used by females)",
            filipino = "Kuya / Ate (Tawag ng babae)",
            pronunciationTip = "Op-pa / Eon-nee",
            exampleKr = "우리 언니는 요리를 정말 잘해요.",
            exampleEn = "My older sister is really good at cooking.",
            exampleFil = "Napakagaling magluto ng ate ko.",
            category = VocabCategory.FAMILY,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_fam_3",
            korean = "형 / 누나",
            romanization = "Hyeong / Nuna",
            english = "Older brother / Older sister (Used by males)",
            filipino = "Kuya / Ate (Tawag ng lalaki)",
            pronunciationTip = "Hyeong / Noo-na",
            exampleKr = "우리 형은 축구를 아주 좋아해요.",
            exampleEn = "My older brother loves soccer very much.",
            exampleFil = "Mahilig mag-football ang kuya ko.",
            category = VocabCategory.FAMILY,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_fam_4",
            korean = "동생 (남동생 / 여동생)",
            romanization = "Dongsaeng",
            english = "Younger sibling (Brother / Sister)",
            filipino = "Bunsong kapatid (Kapatid na lalaki o babae)",
            pronunciationTip = "Dong-saeng",
            exampleKr = "저에게는 귀여운 여동생이 있어요.",
            exampleEn = "I have a cute younger sister.",
            exampleFil = "Mayroon akong kyut na bunsong kapatid na babae.",
            category = VocabCategory.FAMILY,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_fam_5",
            korean = "할아버지 / 할머니",
            romanization = "Harabeoji / Halmeoni",
            english = "Grandfather / Grandmother",
            filipino = "Lolo / Lola",
            pronunciationTip = "Ha-rah-beo-jee / Hal-meo-nee",
            exampleKr = "할머니, 건강하게 오래 사세요.",
            exampleEn = "Grandmother, please live healthy and long.",
            exampleFil = "Lola, magpakalusog po kayo at mabuhay nang matagal.",
            category = VocabCategory.FAMILY,
            difficulty = "Beginner"
        ),

        // ==========================================
        // 9. TIME & DATES (시간과 날짜)
        // ==========================================
        VocabularyItem(
            id = "v_time_1",
            korean = "오늘 / 내일 / 어제",
            romanization = "Oneul / Naeil / Eoje",
            english = "Today / Tomorrow / Yesterday",
            filipino = "Ngayong araw / Bukas / Kahapon",
            pronunciationTip = "O-neul / Nae-eel / Eo-je",
            exampleKr = "오늘 날씨가 참 좋아요.",
            exampleEn = "The weather is very nice today.",
            exampleFil = "Napakaganda ng panahon ngayon.",
            category = VocabCategory.TIME_DATES,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_time_2",
            korean = "지금 몇 시예요?",
            romanization = "Jigeum myeot siyeyo?",
            english = "What time is it right now?",
            filipino = "Anong oras na po ngayon?",
            pronunciationTip = "Jee-geum myeot shee-ye-yo?",
            exampleKr = "지금 오후 3시 30분이에요.",
            exampleEn = "It is 3:30 PM right now.",
            exampleFil = "Alas-tres y medya na po ng hapon ngayon.",
            category = VocabCategory.TIME_DATES,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_time_3",
            korean = "월, 화, 수, 목, 금, 토, 일",
            romanization = "Wol, Hwa, Su, Mok, Geum, To, Il",
            english = "Mon, Tue, Wed, Thu, Fri, Sat, Sun",
            filipino = "Lunes, Martes, Miyerkules, Huwebes, Biyernes, Sabado, Linggo",
            pronunciationTip = "Wol, Hwa, Soo, Mok, Geum, Toh, Eel",
            exampleKr = "토요일과 일요일은 주말이에요.",
            exampleEn = "Saturday and Sunday are the weekend.",
            exampleFil = "Ang Sabado at Linggo ay katapusan ng linggo (weekend).",
            category = VocabCategory.TIME_DATES,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_time_4",
            korean = "오전 / 오후",
            romanization = "Ojeon / Ohu",
            english = "AM (Morning) / PM (Afternoon)",
            filipino = "Nang umaga (AM) / Nang hapon (PM)",
            pronunciationTip = "Oh-jeon / Oh-hoo",
            exampleKr = "오전 9시에 수업이 시작해요.",
            exampleEn = "Class starts at 9:00 AM.",
            exampleFil = "Magsisimula ang klase sa ganap na ika-9 ng umaga.",
            category = VocabCategory.TIME_DATES,
            difficulty = "Beginner"
        ),

        // ==========================================
        // 10. WORKPLACE (직장과 업무)
        // ==========================================
        VocabularyItem(
            id = "v_work_1",
            korean = "회사 / 사무실",
            romanization = "Hoesa / Samusil",
            english = "Company / Office",
            filipino = "Kumpanya / Opisina",
            pronunciationTip = "Hoe-sah / Sah-moo-sheel",
            exampleKr = "내일 아침에 회사로 오세요.",
            exampleEn = "Please come to the company tomorrow morning.",
            exampleFil = "Pumunta po kayo sa opisina bukas ng umaga.",
            category = VocabCategory.WORKPLACE,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_work_2",
            korean = "출근 / 퇴근",
            romanization = "Chulgeun / Toegeun",
            english = "Going to work (Clocking in) / Leaving work (Clocking out)",
            filipino = "Papasok sa trabaho / Uuwi galing sa trabaho (Out)",
            pronunciationTip = "Chool-geun / Toe-geun",
            exampleKr = "오늘 몇 시에 퇴근해요?",
            exampleEn = "What time do you finish work today?",
            exampleFil = "Anong oras ang uwian mo mula sa trabaho ngayon?",
            category = VocabCategory.WORKPLACE,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_work_3",
            korean = "회의",
            romanization = "Hoeui",
            english = "Meeting / Conference",
            filipino = "Miting / Pagpupulong",
            pronunciationTip = "Hoe-wee",
            exampleKr = "오후 2시에 중요한 회의가 있습니다.",
            exampleEn = "There is an important meeting at 2:00 PM.",
            exampleFil = "May mahalagang pulong sa ganap na alas-dos ng hapon.",
            category = VocabCategory.WORKPLACE,
            difficulty = "Intermediate"
        ),
        VocabularyItem(
            id = "v_work_4",
            korean = "월급 / 급여",
            romanization = "Wolgeup / Geubyeo",
            english = "Monthly salary / Pay",
            filipino = "Buwanang Sahod / Suweldo",
            pronunciationTip = "Wol-geup / Geub-yeo",
            exampleKr = "내일이 드디어 월급날이에요!",
            exampleEn = "Tomorrow is finally payday!",
            exampleFil = "Bukas na sa wakas ang araw ng suweldo!",
            category = VocabCategory.WORKPLACE,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_work_5",
            korean = "휴가",
            romanization = "Hyuga",
            english = "Vacation / Leave of absence",
            filipino = "Bakasyon / Bakasyon mula sa trabaho",
            pronunciationTip = "Hyoo-gah",
            exampleKr = "다음 주에 여름 휴가를 떠나요.",
            exampleEn = "I am going on summer vacation next week.",
            exampleFil = "Magbabakasyon ako sa tag-init sa susunod na linggo.",
            category = VocabCategory.WORKPLACE,
            difficulty = "Beginner"
        ),

        // ==========================================
        // 11. TRAVEL (여행)
        // ==========================================
        VocabularyItem(
            id = "v_travel_1",
            korean = "호텔 예약",
            romanization = "Hotel yeyak",
            english = "Hotel reservation",
            filipino = "Reserbasyon sa otel",
            pronunciationTip = "Ho-tel yeh-yak",
            exampleKr = "인터넷으로 호텔을 예약했어요.",
            exampleEn = "I reserved a hotel through the internet.",
            exampleFil = "Nagpareserba ako ng otel sa pamamagitan ng internet.",
            category = VocabCategory.TRAVEL,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_travel_2",
            korean = "여권",
            romanization = "Yeogwon",
            english = "Passport",
            filipino = "Pasaporte",
            pronunciationTip = "Yeo-gwon",
            exampleKr = "여권을 꼭 챙기세요.",
            exampleEn = "Make sure to bring your passport.",
            exampleFil = "Siguraduhing dala mo ang iyong pasaporte.",
            category = VocabCategory.TRAVEL,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_travel_3",
            korean = "비행기표 / 탑승권",
            romanization = "Bihaenggipyo / Tapseunggwon",
            english = "Plane ticket / Boarding pass",
            filipino = "Tiket sa eroplano / Boarding pass",
            pronunciationTip = "Bee-haeng-gee-pyo",
            exampleKr = "비행기표를 보여주세요.",
            exampleEn = "Please show your flight ticket.",
            exampleFil = "Patingin po ng inyong tiket sa eroplano.",
            category = VocabCategory.TRAVEL,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_travel_4",
            korean = "사진 찍어 드릴까요?",
            romanization = "Sajin jjigeo deurilkkayo?",
            english = "Shall I take a photo for you?",
            filipino = "Gusto niyo po bang kuhanan ko kayo ng litrato?",
            pronunciationTip = "Sah-jeen jee-geo deu-reel-kkah-yo?",
            exampleKr = "경복궁 앞에서 사진 한 장 찍어 드릴까요?",
            exampleEn = "Shall I take a photo for you in front of Gyeongbokgung?",
            exampleFil = "Kunan ko po ba kayo ng litrato sa harap ng Gyeongbokgung?",
            category = VocabCategory.TRAVEL,
            difficulty = "Intermediate"
        ),
        VocabularyItem(
            id = "v_travel_5",
            korean = "환전소",
            romanization = "Hwanjeonso",
            english = "Currency exchange booth",
            filipino = "Palitan ng pera (Money changer)",
            pronunciationTip = "Hwan-jeon-so",
            exampleKr = "명동 환전소에서 원화로 바꿨어요.",
            exampleEn = "I exchanged for Korean Won at a Myeongdong money changer.",
            exampleFil = "Nagpapalit ako ng Korean Won sa money changer sa Myeongdong.",
            category = VocabCategory.TRAVEL,
            difficulty = "Intermediate"
        ),

        // ==========================================
        // 12. EMERGENCY PHRASES (비상 표현)
        // ==========================================
        VocabularyItem(
            id = "v_emerg_1",
            korean = "도와주세요!",
            romanization = "Dowajuseyo!",
            english = "Please help me! / Help!",
            filipino = "Saklolo po! / Tulungan niyo po ako!",
            pronunciationTip = "Do-wa-ju-se-yo!",
            exampleKr = "여기요, 도와주세요!",
            exampleEn = "Over here, please help me!",
            exampleFil = "Dito po, tulungan niyo po ako!",
            category = VocabCategory.EMERGENCY,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_emerg_2",
            korean = "병원 / 약국",
            romanization = "Byeongwon / Yakguk",
            english = "Hospital / Pharmacy",
            filipino = "Ospital / Botika (Parmasya)",
            pronunciationTip = "Byeong-won / Yak-gook",
            exampleKr = "근처에 약국이 있어요?",
            exampleEn = "Is there a pharmacy nearby?",
            exampleFil = "May botika po ba malapit dito?",
            category = VocabCategory.EMERGENCY,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_emerg_3",
            korean = "아파요 / 열이 나요",
            romanization = "Apayo / Yeori nayo",
            english = "It hurts / I have a fever",
            filipino = "Masakit / May lagnat po ako",
            pronunciationTip = "Ah-pa-yo / Yeo-ree nah-yo",
            exampleKr = "머리가 너무 아프고 열이 나요.",
            exampleEn = "My head hurts so much and I have a fever.",
            exampleFil = "Masakit na masakit ang ulo ko at nilalagnat ako.",
            category = VocabCategory.EMERGENCY,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_emerg_4",
            korean = "경찰을 불러주세요",
            romanization = "Gyeongchareul bulleojuseyo",
            english = "Please call the police (Dial 112 in Korea)",
            filipino = "Pakitawag po ang pulis (I-dial ang 112 sa Korea)",
            pronunciationTip = "Gyeong-chah-reul bool-leo-joo-seh-yo",
            exampleKr = "위험해요, 경찰을 불러주세요!",
            exampleEn = "It's dangerous, please call the police!",
            exampleFil = "Mapanganib po, pakitawag ang pulis!",
            category = VocabCategory.EMERGENCY,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_emerg_5",
            korean = "지갑을 잃어버렸어요",
            romanization = "Jigabeul ireobeoryeosseoyo",
            english = "I lost my wallet",
            filipino = "Nawala ang aking pitaka",
            pronunciationTip = "Jee-gah-beul ee-reo-beo-ryeoss-eo-yo",
            exampleKr = "지하철에 지갑을 두고 내렸어요.",
            exampleEn = "I left my wallet on the subway.",
            exampleFil = "Naiwan ko ang aking pitaka sa loob ng tren.",
            category = VocabCategory.EMERGENCY,
            difficulty = "Intermediate"
        ),
        VocabularyItem(
            id = "v_emerg_6",
            korean = "길을 잃었어요",
            romanization = "Gireul ireosseoyo",
            english = "I am lost",
            filipino = "Naliligaw po ako",
            pronunciationTip = "Gee-reul ee-reoss-eo-yo",
            exampleKr = "길을 잃었는데 지도를 봐주실 수 있나요?",
            exampleEn = "I'm lost, could you look at this map for me?",
            exampleFil = "Naliligaw po ako, maaari niyo po bang tingnan ang mapang ito?",
            category = VocabCategory.EMERGENCY,
            difficulty = "Beginner"
        ),

        // ==========================================
        // 13. EVERYDAY VERBS (일상 동사)
        // ==========================================
        VocabularyItem(
            id = "v_verb_1",
            korean = "가다 / 오다",
            romanization = "Gada / Oda",
            english = "To go / To come",
            filipino = "Pumunta / Dumating (Pumarito)",
            pronunciationTip = "Ga-da / O-da",
            exampleKr = "집에 가요. / 이리 오세요.",
            exampleEn = "I go home. / Please come here.",
            exampleFil = "Uuwi ako sa bahay. / Halika po rito.",
            category = VocabCategory.VERBS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_verb_2",
            korean = "먹다 / 마시다",
            romanization = "Meokda / Masida",
            english = "To eat / To drink",
            filipino = "Kumain / Uminom",
            pronunciationTip = "Meok-da / Ma-shee-da",
            exampleKr = "점심을 맛있게 먹었어요.",
            exampleEn = "I ate lunch deliciously.",
            exampleFil = "Masarap kong kinain ang tanghalian.",
            category = VocabCategory.VERBS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_verb_3",
            korean = "공부하다",
            romanization = "Gongbuhada",
            english = "To study",
            filipino = "Mag-aral",
            pronunciationTip = "Gong-boo-ha-da",
            exampleKr = "한국어를 매일 열심히 공부해요.",
            exampleEn = "I study Korean hard every day.",
            exampleFil = "Matiyaga akong nag-aaral ng wikang Korean araw-araw.",
            category = VocabCategory.VERBS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_verb_4",
            korean = "자다 / 일어나다",
            romanization = "Jada / Ireonada",
            english = "To sleep / To wake up",
            filipino = "Matulog / Gumising",
            pronunciationTip = "Jah-da / Ee-reo-nah-da",
            exampleKr = "보통 아침 7시에 일어나요.",
            exampleEn = "I usually wake up at 7:00 AM.",
            exampleFil = "Karaniwan akong gumigising sa ganap na ika-7 ng umaga.",
            category = VocabCategory.VERBS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_verb_5",
            korean = "보다 / 듣다",
            romanization = "Boda / Deutda",
            english = "To see (watch) / To listen (hear)",
            filipino = "Manood (Tumingin) / Makinig",
            pronunciationTip = "Boh-da / Deuk-da",
            exampleKr = "한국 드라마를 보고 음악을 들어요.",
            exampleEn = "I watch K-dramas and listen to music.",
            exampleFil = "Nanunood ako ng K-drama at nakikinig ng musika.",
            category = VocabCategory.VERBS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_verb_6",
            korean = "사다 / 팔다",
            romanization = "Sada / Palda",
            english = "To buy / To sell",
            filipino = "Bumili / Magbenta",
            pronunciationTip = "Sah-da / Pahl-da",
            exampleKr = "시장에서 신선한 과일을 샀어요.",
            exampleEn = "I bought fresh fruit at the market.",
            exampleFil = "Bumili ako ng sariwang prutas sa palengke.",
            category = VocabCategory.VERBS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_verb_7",
            korean = "기다리다 / 만나다",
            romanization = "Gidarida / Mannada",
            english = "To wait / To meet",
            filipino = "Maghintay / Makipagkita",
            pronunciationTip = "Gee-dah-ree-da / Mahn-nah-da",
            exampleKr = "카페에서 친구를 기다리고 있어요.",
            exampleEn = "I am waiting for a friend at the cafe.",
            exampleFil = "Naghihintay ako ng kaibigan sa kapehan.",
            category = VocabCategory.VERBS,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_verb_8",
            korean = "일하다 / 쉬다",
            romanization = "Ilhada / Swida",
            english = "To work / To rest",
            filipino = "Magtrabaho / Magpahinga",
            pronunciationTip = "Eel-ha-da / Swee-da",
            exampleKr = "주말에는 집에서 푹 쉬어요.",
            exampleEn = "On the weekend, I rest well at home.",
            exampleFil = "Tuwing weekend, nagpapahinga ako nang husto sa bahay.",
            category = VocabCategory.VERBS,
            difficulty = "Beginner"
        ),

        // ==========================================
        // 14. COMMON ADJECTIVES (형용사)
        // ==========================================
        VocabularyItem(
            id = "v_adj_1",
            korean = "좋다 / 나쁘다",
            romanization = "Jota / Nappeuda",
            english = "Good / Bad",
            filipino = "Mabuti (Maganda) / Masama",
            pronunciationTip = "Jo-ta / Nah-ppeu-da",
            exampleKr = "기분이 정말 좋아요.",
            exampleEn = "I feel really good.",
            exampleFil = "Napakaganda ng pakiramdam ko.",
            category = VocabCategory.ADJECTIVES,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_adj_2",
            korean = "예쁘다",
            romanization = "Yeppeuda",
            english = "Pretty / Beautiful",
            filipino = "Maganda",
            pronunciationTip = "Ye-ppeu-da",
            exampleKr = "꽃이 참 예뻐요.",
            exampleEn = "The flowers are truly pretty.",
            exampleFil = "Tunay na napakaganda ng mga bulaklak.",
            category = VocabCategory.ADJECTIVES,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_adj_3",
            korean = "크다 / 작다",
            romanization = "Keuda / Jakda",
            english = "Big / Small",
            filipino = "Malaki / Maliit",
            pronunciationTip = "Keu-da / Jak-da",
            exampleKr = "서울은 아주 큰 도시예요.",
            exampleEn = "Seoul is a very big city.",
            exampleFil = "Ang Seoul ay napakalaking lungsod.",
            category = VocabCategory.ADJECTIVES,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_adj_4",
            korean = "많다 / 적다",
            romanization = "Manta / Jeokda",
            english = "Many (Much) / Few (Little)",
            filipino = "Marami / Kakaunti",
            pronunciationTip = "Man-ta / Jeok-da",
            exampleKr = "지하철에 사람이 아주 많아요.",
            exampleEn = "There are so many people on the subway.",
            exampleFil = "Napakaraming tao sa loob ng tren.",
            category = VocabCategory.ADJECTIVES,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_adj_5",
            korean = "춥다 / 덥다",
            romanization = "Chupda / Deopda",
            english = "Cold / Hot (Weather)",
            filipino = "Malamig / Mainit (Panahon)",
            pronunciationTip = "Choop-da / Deop-da",
            exampleKr = "한국의 겨울은 춥지만 눈이 와서 아름다워요.",
            exampleEn = "Korean winters are cold, but beautiful with snow.",
            exampleFil = "Malamig ang taglamig sa Korea, ngunit maganda dahil may niyebe.",
            category = VocabCategory.ADJECTIVES,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_adj_6",
            korean = "빠르다 / 느리다",
            romanization = "Ppareuda / Neurida",
            english = "Fast / Slow",
            filipino = "Mabilis / Mabagal",
            pronunciationTip = "Ppa-reu-da / Neu-ree-da",
            exampleKr = "인터넷 속도가 정말 빨라요.",
            exampleEn = "The internet speed is really fast.",
            exampleFil = "Napakabilis ng bilis ng internet.",
            category = VocabCategory.ADJECTIVES,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_adj_7",
            korean = "어렵다 / 쉽다",
            romanization = "Eoryeopda / Swipda",
            english = "Difficult / Easy",
            filipino = "Mahirap / Madali",
            pronunciationTip = "Eo-ryeop-da / Sweep-da",
            exampleKr = "한글 읽기는 생각보다 쉬워요.",
            exampleEn = "Reading Hangul is easier than you think.",
            exampleFil = "Mas madaling magbasa ng Hangul kaysa sa inaakala mo.",
            category = VocabCategory.ADJECTIVES,
            difficulty = "Beginner"
        ),
        VocabularyItem(
            id = "v_adj_8",
            korean = "재미있다 / 재미없다",
            romanization = "Jaemiitda / Jaemieopda",
            english = "Fun (Interesting) / Boring (Not fun)",
            filipino = "Masaya (Kawili-wili) / Walang kabuhay-buhay (Nakakainip)",
            pronunciationTip = "Jae-mee-eet-da",
            exampleKr = "한국어 공부가 정말 재미있어요!",
            exampleEn = "Studying Korean is really fun!",
            exampleFil = "Napakasayang mag-aral ng wikang Korean!",
            category = VocabCategory.ADJECTIVES,
            difficulty = "Beginner"
        )
    )

    val dailyWord = items.first { it.id == "v_food_1" } // 물 (mul)
    val dailyPhrase = VocabularyItem(
        id = "daily_phrase_1",
        korean = "물 주세요.",
        romanization = "Mul juseyo.",
        english = "Please give me water.",
        filipino = "Pahingi po ng tubig.",
        pronunciationTip = "Mool joo-seh-yo",
        exampleKr = "시원한 물 좀 주세요.",
        exampleEn = "Please give me some cold water.",
        exampleFil = "Pahingi naman po ng malamig na tubig.",
        category = VocabCategory.FOOD_DRINKS,
        difficulty = "Beginner"
    )
}
