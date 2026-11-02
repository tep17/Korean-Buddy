package com.example.data

import com.example.model.BatchimRule
import com.example.model.HangulCategory
import com.example.model.HangulCharacter
import com.example.model.WordExample

object HangulData {

    val basicConsonants = listOf(
        HangulCharacter(
            char = "ㄱ",
            name = "기역 (giyeok)",
            category = HangulCategory.BASIC_CONSONANT,
            englishSound = "g / k",
            filipinoSound = "g / k (tulad sa 'guro' o 'kutsara')",
            englishExplanation = "Sounds like 'g' at the start of a syllable before a vowel, but softer like 'k' at the end of a syllable or word.",
            filipinoExplanation = "Tunog 'g' sa unahan ng pantig bago ang patinig, at parang banayad na 'k' sa dulo ng salita o pantig.",
            mouthTipEn = "Tongue tip rests behind lower teeth, back of tongue raises to touch soft palate.",
            mouthTipFil = "Ang dulo ng dila ay nakalapat sa likod ng ibabang ngipin, ang likod ng dila ay umaangat sa ngala-ngala.",
            strokeCount = 1,
            strokeGuide = listOf("1. Start top-left, draw right, then curve down at 90 degrees."),
            exampleSyllables = listOf("가 (ga)", "구 (gu)", "고 (go)", "기 (gi)"),
            exampleWords = listOf(
                WordExample("가방", "gabang", "Bag", "Bag / Supot"),
                WordExample("고기", "gogi", "Meat", "Karne")
            )
        ),
        HangulCharacter(
            char = "ㄴ",
            name = "니은 (nieun)",
            category = HangulCategory.BASIC_CONSONANT,
            englishSound = "n",
            filipinoSound = "n (tulad sa 'nanay')",
            englishExplanation = "Sounds like the 'n' in 'nice' or 'no'. Represents the tongue touching the upper gum ridge.",
            filipinoExplanation = "Tunog 'n' tulad ng sa Tagalog na 'nanay' o 'nars'. Ang hugis ay sumasagisag sa dila na dumidikit sa gilagid.",
            mouthTipEn = "Tip of tongue touches behind upper front teeth, air exits through nose.",
            mouthTipFil = "Dulo ng dila ay dumidikit sa itaas na gilagid, hangin ay dumadaan sa ilong.",
            strokeCount = 1,
            strokeGuide = listOf("1. Draw straight down, then turn right 90 degrees."),
            exampleSyllables = listOf("나 (na)", "누 (nu)", "노 (no)", "니 (ni)"),
            exampleWords = listOf(
                WordExample("나무", "namu", "Tree", "Puno"),
                WordExample("나라", "nara", "Country", "Bansa")
            )
        ),
        HangulCharacter(
            char = "ㄷ",
            name = "디귿 (digeut)",
            category = HangulCategory.BASIC_CONSONANT,
            englishSound = "d / t",
            filipinoSound = "d / t (tulad sa 'dahon' o 'tao')",
            englishExplanation = "Sounds like 'd' at the start of a syllable, and like an unreleased 't' at the end.",
            filipinoExplanation = "Tunog 'd' sa simula tulad ng 'dahon', at parang 't' sa dulo ng pantig.",
            mouthTipEn = "Tongue firmly taps the alveolar ridge behind upper teeth.",
            mouthTipFil = "Dila ay marahang pumipindot sa likod ng itaas na ngipin.",
            strokeCount = 2,
            strokeGuide = listOf("1. Top horizontal line left to right.", "2. Vertical down and bottom horizontal right."),
            exampleSyllables = listOf("다 (da)", "두 (du)", "도 (do)", "디 (di)"),
            exampleWords = listOf(
                WordExample("다리", "dari", "Leg / Bridge", "Binti / Tulay"),
                WordExample("돈", "don", "Money", "Pera")
            )
        ),
        HangulCharacter(
            char = "ㄹ",
            name = "리을 (rieul)",
            category = HangulCategory.BASIC_CONSONANT,
            englishSound = "r / l",
            filipinoSound = "r / l (tulad sa 'relo' o 'lapis')",
            englishExplanation = "Sounds like a light flap 'r' between vowels (like 'tt' in American 'butter'), and 'l' at the end of a syllable.",
            filipinoExplanation = "Tunog 'r' kapag nasa pagitan ng patinig (flapped r), at tunog 'l' kapag nasa dulo ng pantig o salita.",
            mouthTipEn = "Light single tap of the tongue against the roof of the mouth.",
            mouthTipFil = "Isang mabilis na pagdampi ng dila sa bubong ng bibig.",
            strokeCount = 3,
            strokeGuide = listOf("1. Right and down (like ㄱ).", "2. Middle horizontal line.", "3. Down and right (like ㄴ)."),
            exampleSyllables = listOf("라 (ra)", "루 (ru)", "로 (ro)", "리 (ri)"),
            exampleWords = listOf(
                WordExample("라면", "ramyeon", "Ramen noodles", "Ramen / Pansit"),
                WordExample("물", "mul", "Water", "Tubig")
            )
        ),
        HangulCharacter(
            char = "ㅁ",
            name = "미음 (mieum)",
            category = HangulCategory.BASIC_CONSONANT,
            englishSound = "m",
            filipinoSound = "m (tulad sa 'mata')",
            englishExplanation = "Sounds exactly like 'm' in 'mother'. Shaped like a closed mouth.",
            filipinoExplanation = "Eksaktong tunog 'm' tulad ng 'manok' o 'mata'. Hugis saradong bibig.",
            mouthTipEn = "Both lips closed together, sound vibrates through nasal passage.",
            mouthTipFil = "Magkadikit ang dalawang labi habang lumalabas ang tunog sa ilong.",
            strokeCount = 3,
            strokeGuide = listOf("1. Left vertical down.", "2. Top horizontal and right vertical.", "3. Bottom horizontal closing the box."),
            exampleSyllables = listOf("마 (ma)", "무 (mu)", "모 (mo)", "미 (mi)"),
            exampleWords = listOf(
                WordExample("마음", "maeum", "Heart / Mind", "Puso / Saloobin"),
                WordExample("모자", "moja", "Hat / Cap", "Sombrero")
            )
        ),
        HangulCharacter(
            char = "ㅂ",
            name = "비읍 (bieup)",
            category = HangulCategory.BASIC_CONSONANT,
            englishSound = "b / p",
            filipinoSound = "b / p (tulad sa 'bahay' o 'pinto')",
            englishExplanation = "Sounds like 'b' at the start of a syllable, and unreleased 'p' at the end.",
            filipinoExplanation = "Tunog 'b' sa simula tulad ng 'bata', at 'p' kapag nasa dulo tulad ng 'talipandas'.",
            mouthTipEn = "Lips close, slight pressure releases without strong puff of air.",
            mouthTipFil = "Nakasara ang mga labi, banayad na pinakakawalan ang hangin nang walang buga.",
            strokeCount = 4,
            strokeGuide = listOf("1. Left vertical down.", "2. Right vertical down.", "3. Middle horizontal.", "4. Bottom horizontal."),
            exampleSyllables = listOf("바 (ba)", "부 (bu)", "보 (bo)", "비 (bi)"),
            exampleWords = listOf(
                WordExample("밥", "bap", "Cooked rice / Meal", "Kanin / Pagkain"),
                WordExample("바다", "bada", "Sea / Ocean", "Dagat")
            )
        ),
        HangulCharacter(
            char = "ㅅ",
            name = "시옷 (siot)",
            category = HangulCategory.BASIC_CONSONANT,
            englishSound = "s / sh",
            filipinoSound = "s / sh (tulad sa 'saging' o 'sapatos')",
            englishExplanation = "Sounds like 's' before most vowels, but becomes 'sh' before 'i' (ㅣ) or 'y' vowels (ㅑ, ㅕ, ㅛ, ㅠ).",
            filipinoExplanation = "Tunog 's' sa karamihan ng patinig, ngunit nagiging 'sh' kapag sinusundan ng 'ㅣ' (i) o mga 'y' patinig.",
            mouthTipEn = "Tongue close to roof of mouth, air hisses gently through.",
            mouthTipFil = "Dila ay malapit sa bubong ng bibig habang dahan-dahang sumisingaw ang hangin.",
            strokeCount = 2,
            strokeGuide = listOf("1. Diagonal stroke from top down to left.", "2. Diagonal stroke from middle down to right."),
            exampleSyllables = listOf("사 (sa)", "수 (su)", "소 (so)", "시 (shi)"),
            exampleWords = listOf(
                WordExample("사람", "saram", "Person", "Tao"),
                WordExample("시간", "shigan", "Time / Hour", "Oras")
            )
        ),
        HangulCharacter(
            char = "ㅇ",
            name = "이응 (ieung)",
            category = HangulCategory.BASIC_CONSONANT,
            englishSound = "Silent (initial) / ng (final)",
            filipinoSound = "Walang tunog (sa simula) / ng (sa dulo)",
            englishExplanation = "When at the start of a syllable, it is completely silent and acts as a vowel placeholder. At the bottom (batchim), it sounds like 'ng' in 'song'.",
            filipinoExplanation = "Kapag nasa simula ng pantig, ito ay walang tunog (placeholder lamang ng patinig). Kapag nasa ilalim (batchim), tunog 'ng' ito tulad sa 'ngipin'.",
            mouthTipEn = "As final 'ng': Back of tongue touches velum with sound through nose.",
            mouthTipFil = "Kapag 'ng': Likod ng dila ay sumasayad sa ngala-ngala at lumalabas sa ilong ang tunog.",
            strokeCount = 1,
            strokeGuide = listOf("1. Smooth circle starting from top counter-clockwise back to top."),
            exampleSyllables = listOf("아 (a)", "우 (u)", "오 (o)", "이 (i)", "강 (gang)"),
            exampleWords = listOf(
                WordExample("아이", "ai", "Child", "Bata"),
                WordExample("사랑", "sarang", "Love", "Pag-ibig")
            )
        ),
        HangulCharacter(
            char = "ㅈ",
            name = "지읒 (jieut)",
            category = HangulCategory.BASIC_CONSONANT,
            englishSound = "j / ch",
            filipinoSound = "dy / j (tulad sa 'dyip' o 'dyaryo')",
            englishExplanation = "Sounds like a soft 'j' in 'jam' or 'jeep'. Not as heavy as English 'j'.",
            filipinoExplanation = "Tunog 'dy' o malumanay na 'j' tulad ng sa salitang 'dyipni'.",
            mouthTipEn = "Tongue blade touches hard palate and releases gently.",
            mouthTipFil = "Lapad ng dila ay dumidikit sa matigas na ngala-ngala bago marahang bumukas.",
            strokeCount = 2,
            strokeGuide = listOf("1. Top horizontal bar.", "2. Down-left and down-right legs (or combined)."),
            exampleSyllables = listOf("자 (ja)", "주 (ju)", "조 (jo)", "지 (ji)"),
            exampleWords = listOf(
                WordExample("지도", "jido", "Map", "Mapa"),
                WordExample("자다", "jada", "To sleep", "Matulog")
            )
        ),
        HangulCharacter(
            char = "ㅊ",
            name = "치읓 (chieut)",
            category = HangulCategory.BASIC_CONSONANT,
            englishSound = "ch",
            filipinoSound = "ts / ch (tulad sa 'tsinelas' o 'tsokolate')",
            englishExplanation = "Aspirated consonant! Sounds like 'ch' in 'cheese' with a noticeable burst of air.",
            filipinoExplanation = "Aspiradong katinig na may buga ng hangin! Tunog 'ts' tulad ng 'tsinelas' o 'tsaa'.",
            mouthTipEn = "Same position as ㅈ, but release with an explosive burst of breath.",
            mouthTipFil = "Parehong posisyon sa ㅈ, ngunit pakawalan na may kasamang malakas na buga ng hangin.",
            strokeCount = 3,
            strokeGuide = listOf("1. Small top dot/horizontal.", "2. Horizontal bar.", "3. Two legs downward."),
            exampleSyllables = listOf("차 (cha)", "추 (chu)", "초 (cho)", "치 (chi)"),
            exampleWords = listOf(
                WordExample("친구", "chingu", "Friend", "Kaibigan"),
                WordExample("차", "cha", "Tea / Car", "Tsaa / Kotse")
            )
        ),
        HangulCharacter(
            char = "ㅋ",
            name = "키읔 (kieuk)",
            category = HangulCategory.BASIC_CONSONANT,
            englishSound = "k (aspirated)",
            filipinoSound = "k na may buga ng hangin (tulad sa 'kendi')",
            englishExplanation = "Aspirated 'k'! Strong burst of air like 'k' in 'kitchen'. Compare to ㄱ which has no air burst.",
            filipinoExplanation = "Malakas na tunog 'k' na may hanging sumasabog! Ihambing sa ㄱ na walang buga.",
            mouthTipEn = "Back of tongue releases sharply with a puff of air.",
            mouthTipFil = "Likod ng dila ay biglang bumubuka na may buga ng hangin.",
            strokeCount = 2,
            strokeGuide = listOf("1. Right and down (like ㄱ).", "2. Middle horizontal stroke."),
            exampleSyllables = listOf("카 (ka)", "쿠 (ku)", "코 (ko)", "키 (ki)"),
            exampleWords = listOf(
                WordExample("커피", "keopi", "Coffee", "Kape"),
                WordExample("코", "ko", "Nose", "Ilong")
            )
        ),
        HangulCharacter(
            char = "ㅌ",
            name = "티읕 (tieut)",
            category = HangulCategory.BASIC_CONSONANT,
            englishSound = "t (aspirated)",
            filipinoSound = "t na may buga ng hangin (tulad sa 'tinapay')",
            englishExplanation = "Aspirated 't'! Sounds like 't' in 'tea' with an audible puff of breath.",
            filipinoExplanation = "Malakas na tunog 't' na may buga ng hangin, parang 't' sa Ingles na 'table'.",
            mouthTipEn = "Tongue tip behind teeth releases with sharp puff of air.",
            mouthTipFil = "Dulo ng dila sa likod ng ngipin ay bumibitaw na may kasamang bugso ng hangin.",
            strokeCount = 3,
            strokeGuide = listOf("1. Top horizontal bar.", "2. Middle horizontal bar.", "3. Bottom horizontal connected by left vertical."),
            exampleSyllables = listOf("타 (ta)", "투 (tu)", "토 (to)", "티 (ti)"),
            exampleWords = listOf(
                WordExample("태양", "taeyang", "Sun", "Araw"),
                WordExample("토끼", "tokki", "Rabbit", "Kuneho")
            )
        ),
        HangulCharacter(
            char = "ㅍ",
            name = "피읖 (pieup)",
            category = HangulCategory.BASIC_CONSONANT,
            englishSound = "p (aspirated)",
            filipinoSound = "p na may buga ng hangin (tulad sa 'panyo')",
            englishExplanation = "Aspirated 'p'! Strong burst of breath from the lips, like 'p' in 'pool'.",
            filipinoExplanation = "Malakas na tunog 'p' na sumasabog mula sa labi, tulad ng 'p' sa 'party'.",
            mouthTipEn = "Lips pop open with a noticeable burst of air.",
            mouthTipFil = "Bumubuka ang mga labi na may kasamang malinaw na buga ng hangin.",
            strokeCount = 4,
            strokeGuide = listOf("1. Top horizontal bar.", "2. Left vertical down.", "3. Right vertical down.", "4. Bottom horizontal bar."),
            exampleSyllables = listOf("파 (pa)", "푸 (pu)", "포 (po)", "피 (pi)"),
            exampleWords = listOf(
                WordExample("피자", "pija", "Pizza", "Pizza"),
                WordExample("파란색", "paransaek", "Blue color", "Kulay asul")
            )
        ),
        HangulCharacter(
            char = "ㅎ",
            name = "히읗 (hieut)",
            category = HangulCategory.BASIC_CONSONANT,
            englishSound = "h",
            filipinoSound = "h (tulad sa 'hangin' o 'halaman')",
            englishExplanation = "Sounds like 'h' in 'hello'. Gentle exhalation through an open mouth.",
            filipinoExplanation = "Tunog 'h' tulad sa 'halaman' o 'hangin'. Marahang paghinga palabas.",
            mouthTipEn = "Throat and mouth open, smooth whisper of air from vocal cords.",
            mouthTipFil = "Bukas ang bibig at lalamunan, malumanay na paglabas ng hangin.",
            strokeCount = 3,
            strokeGuide = listOf("1. Small top horizontal stroke.", "2. Wider middle horizontal stroke.", "3. Circle below."),
            exampleSyllables = listOf("하 (ha)", "후 (hu)", "호 (ho)", "히 (hi)"),
            exampleWords = listOf(
                WordExample("하늘", "haneul", "Sky", "Langit"),
                WordExample("한국", "hanguk", "Korea", "Korea")
            )
        )
    )

    val doubleConsonants = listOf(
        HangulCharacter(
            char = "ㄲ",
            name = "쌍기역 (ssang-giyeok)",
            category = HangulCategory.DOUBLE_CONSONANT,
            englishSound = "kk (tense)",
            filipinoSound = "matigas at tensyonadong k",
            englishExplanation = "Tense consonant! Pronounced with a tightened throat and zero air breath. Sounds like the hard 'k' in 'sky'.",
            filipinoExplanation = "Tensyonadong katinig! Binibigkas nang mahigpit ang lalamunan at walang buga ng hangin. Matigas na 'k'.",
            mouthTipEn = "Tense throat muscles, hold breath for a split second before releasing.",
            mouthTipFil = "Higpitan ang lalamunan bago pakawalan ang matigas na tunog.",
            strokeCount = 2,
            strokeGuide = listOf("Write two ㄱ characters tightly next to each other."),
            exampleSyllables = listOf("까 (kka)", "꾸 (kku)", "꼬 (kko)", "끼 (kki)"),
            exampleWords = listOf(
                WordExample("꿈", "kkum", "Dream", "Panaginip / Pangarap"),
                WordExample("꼬리", "kkori", "Tail", "Buntot")
            )
        ),
        HangulCharacter(
            char = "ㄸ",
            name = "쌍디귿 (ssang-digeut)",
            category = HangulCategory.DOUBLE_CONSONANT,
            englishSound = "tt (tense)",
            filipinoSound = "matigas at tensyonadong t",
            englishExplanation = "Tense 'tt'! Tight vocal cords, no air burst. Sounds like the 't' in 'stop'.",
            filipinoExplanation = "Matigas na 't'! Walang hanging sumasabog, tulad ng madiing 't' sa 'tatay'.",
            mouthTipEn = "Press tongue against teeth with tension, release without breath.",
            mouthTipFil = "Mariing idampi ang dila sa ngipin at bitawan nang walang hangin.",
            strokeCount = 4,
            strokeGuide = listOf("Write two ㄷ characters side by side."),
            exampleSyllables = listOf("따 (tta)", "뚜 (ttu)", "또 (tto)", "띠 (tti)"),
            exampleWords = listOf(
                WordExample("딸", "ttal", "Daughter", "Anak na babae"),
                WordExample("떡", "tteok", "Rice cake", "Rice cake / Kakanin")
            )
        ),
        HangulCharacter(
            char = "ㅃ",
            name = "쌍비읍 (ssang-bieup)",
            category = HangulCategory.DOUBLE_CONSONANT,
            englishSound = "pp (tense)",
            filipinoSound = "matigas at tensyonadong p",
            englishExplanation = "Tense 'pp'! Press lips tightly together, no puff of air. Sounds like 'p' in 'spoon'.",
            filipinoExplanation = "Matigas na 'p'! Idikit nang mariin ang mga labi, walang buga ng hangin tulad sa 'pula'.",
            mouthTipEn = "Lips clamped firmly, release with popping pressure.",
            mouthTipFil = "Mariing isara ang mga labi at pakawalan nang may presyon.",
            strokeCount = 8,
            strokeGuide = listOf("Write two ㅂ characters side by side."),
            exampleSyllables = listOf("빠 (ppa)", "뿌 (ppu)", "뽀 (ppo)", "삐 (ppi)"),
            exampleWords = listOf(
                WordExample("빵", "ppang", "Bread", "Tinapay"),
                WordExample("빨리", "ppalli", "Quickly / Hurry", "Bilis / Dalian")
            )
        ),
        HangulCharacter(
            char = "ㅆ",
            name = "쌍시옷 (ssang-siot)",
            category = HangulCategory.DOUBLE_CONSONANT,
            englishSound = "ss (tense)",
            filipinoSound = "madiin at tensyonadong s",
            englishExplanation = "Tense 'ss'! Sharper and more intense hiss than single ㅅ. Sounds like the hissing 's' in 'hiss'.",
            filipinoExplanation = "Madiin na tunog 's'! Mas matalim at mabilis na pagsingaw kaysa sa karaniwang ㅅ.",
            mouthTipEn = "Tense tongue against palate, produce a sharp, tight hiss.",
            mouthTipFil = "Higpitan ang dila upang makalikha ng matalim at madiing 's'.",
            strokeCount = 4,
            strokeGuide = listOf("Write two ㅅ characters side by side."),
            exampleSyllables = listOf("싸 (ssa)", "쑤 (ssu)", "쏘 (sso)", "씨 (ssi)"),
            exampleWords = listOf(
                WordExample("싸다", "ssada", "Cheap / Inexpensive", "Mura (ang presyo)"),
                WordExample("쓰다", "sseuda", "To write / To use", "Magsulat / Gamitin")
            )
        ),
        HangulCharacter(
            char = "ㅉ",
            name = "쌍지읒 (ssang-jieut)",
            category = HangulCategory.DOUBLE_CONSONANT,
            englishSound = "jj (tense)",
            filipinoSound = "matigas at tensyonadong dy/j",
            englishExplanation = "Tense 'jj'! Tight vocal tension, sharp and crisp sound with no air burst.",
            filipinoExplanation = "Matigas at tensyonadong 'dy'! Walang buga ng hangin, malinaw at madiin.",
            mouthTipEn = "Tight contact of tongue to roof of mouth, crisp release.",
            mouthTipFil = "Mariing pagkakadikit ng dila sa ngala-ngala bago pakawalan nang matalim.",
            strokeCount = 4,
            strokeGuide = listOf("Write two ㅈ characters side by side."),
            exampleSyllables = listOf("짜 (jja)", "쭈 (jju)", "쪼 (jjo)", "찌 (jji)"),
            exampleWords = listOf(
                WordExample("짜다", "jjada", "Salty", "Maalat"),
                WordExample("진짜", "jinjja", "Really / Truly", "Talaga / Totoo")
            )
        )
    )

    val basicVowels = listOf(
        HangulCharacter(
            char = "ㅏ",
            name = "아 (a)",
            category = HangulCategory.BASIC_VOWEL,
            englishSound = "a",
            filipinoSound = "a (tulad sa 'araw')",
            englishExplanation = "Sounds like 'ah' in 'father'. Wide open mouth.",
            filipinoExplanation = "Tunog 'a' tulad sa 'araw' o 'ama'. Bukas ang bibig.",
            mouthTipEn = "Open mouth vertically wide, jaw relaxed down.",
            mouthTipFil = "Buksan nang malaki ang bibig pababa, relaks ang panga.",
            strokeCount = 2,
            strokeGuide = listOf("1. Vertical line from top to bottom.", "2. Short horizontal line to the right from the middle."),
            exampleSyllables = listOf("아 (a)", "가 (ga)", "나 (na)", "다 (da)"),
            exampleWords = listOf(
                WordExample("아버지", "abeoji", "Father", "Tatay / Ama"),
                WordExample("아침", "achim", "Morning / Breakfast", "Umaga / Almusal")
            )
        ),
        HangulCharacter(
            char = "ㅑ",
            name = "야 (ya)",
            category = HangulCategory.BASIC_VOWEL,
            englishSound = "ya",
            filipinoSound = "ya (tulad sa 'yaya')",
            englishExplanation = "Sounds like 'ya' in 'yacht'. The extra stroke adds the 'y' glide sound.",
            filipinoExplanation = "Tunog 'ya' tulad sa 'yaya' o 'yate'. Ang dalawang guhit ay nagdaragdag ng tunog na 'y'.",
            mouthTipEn = "Glide quickly from 'ee' into open 'ah'.",
            mouthTipFil = "Mabilis na dumaan mula 'i' patungong malaking 'a'.",
            strokeCount = 3,
            strokeGuide = listOf("1. Vertical line top to bottom.", "2. First short horizontal right.", "3. Second short horizontal right."),
            exampleSyllables = listOf("야 (ya)", "갸 (gya)", "냐 (nya)", "샤 (sha)"),
            exampleWords = listOf(
                WordExample("야구", "yagu", "Baseball", "Baseball"),
                WordExample("약", "yak", "Medicine", "Gamot")
            )
        ),
        HangulCharacter(
            char = "ㅓ",
            name = "어 (eo)",
            category = HangulCategory.BASIC_VOWEL,
            englishSound = "eo (uh / aw)",
            filipinoSound = "malumanay na o/u (tulad sa Ingles na 'cup')",
            englishExplanation = "Sounds like the 'u' in 'cup' or 'sun', or 'aw' in 'saw' without rounding lips. Crucial Korean vowel!",
            filipinoExplanation = "Tunog sa pagitan ng 'o' at 'a', tulad ng 'u' sa Ingles na 'run' o 'sun'. Hindi bilog ang mga labi.",
            mouthTipEn = "Open mouth moderately, do NOT round your lips. Keep lips relaxed and flat.",
            mouthTipFil = "Buksan nang katamtaman ang bibig nang HINDI ibinibilog ang mga labi.",
            strokeCount = 2,
            strokeGuide = listOf("1. Short horizontal line from left to center.", "2. Long vertical line top to bottom."),
            exampleSyllables = listOf("어 (eo)", "거 (geo)", "너 (neo)", "더 (deo)"),
            exampleWords = listOf(
                WordExample("어머니", "eomeoni", "Mother", "Nanay / Ina"),
                WordExample("언니", "eonni", "Older sister (used by female)", "Ate (tawag ng babae)")
            )
        ),
        HangulCharacter(
            char = "ㅕ",
            name = "여 (yeo)",
            category = HangulCategory.BASIC_VOWEL,
            englishSound = "yeo",
            filipinoSound = "yeo (y + tunog ng 어)",
            englishExplanation = "Glide 'y' + 'eo'. Sounds like 'yuh' in 'young'.",
            filipinoExplanation = "Tunog 'y' na sinusundan ng 'eo' tulad sa Ingles na 'young'.",
            mouthTipEn = "Start with 'ee' and smoothly glide into the unrounded 'eo'.",
            mouthTipFil = "Magsimula sa 'i' at dumulas sa patinig na 'eo'.",
            strokeCount = 3,
            strokeGuide = listOf("1. Two short horizontal lines on the left.", "2. Long vertical line top to bottom."),
            exampleSyllables = listOf("여 (yeo)", "겨 (gyeo)", "녀 (nyeo)", "려 (ryeo)"),
            exampleWords = listOf(
                WordExample("여자", "yeoja", "Woman", "Babae"),
                WordExample("여권", "yeogwon", "Passport", "Pasaporte")
            )
        ),
        HangulCharacter(
            char = "ㅗ",
            name = "오 (o)",
            category = HangulCategory.BASIC_VOWEL,
            englishSound = "o",
            filipinoSound = "o (tulad sa 'orasan')",
            englishExplanation = "Sounds like 'o' in 'home' or 'boat'. Lips are rounded into an 'O' shape.",
            filipinoExplanation = "Tunog 'o' tulad sa 'orasan'. Nakabilog nang husto ang mga labi.",
            mouthTipEn = "Push lips forward into a tight round circle.",
            mouthTipFil = "Ipihit nang pabilog at paabante ang mga labi.",
            strokeCount = 2,
            strokeGuide = listOf("1. Short vertical stroke from top downward.", "2. Long horizontal stroke left to right below it."),
            exampleSyllables = listOf("오 (o)", "고 (go)", "노 (no)", "도 (do)"),
            exampleWords = listOf(
                WordExample("오늘", "oneul", "Today", "Ngayong araw"),
                WordExample("오빠", "oppa", "Older brother (used by female)", "Kuya (tawag ng babae)")
            )
        ),
        HangulCharacter(
            char = "ㅛ",
            name = "요 (yo)",
            category = HangulCategory.BASIC_VOWEL,
            englishSound = "yo",
            filipinoSound = "yo (tulad sa 'yoyo')",
            englishExplanation = "Sounds like 'yo' in 'yoga' or 'yo-yo'.",
            filipinoExplanation = "Tunog 'yo' tulad sa 'yoyo'.",
            mouthTipEn = "Glide from 'y' into rounded 'o'.",
            mouthTipFil = "Dumulas mula sa 'y' patungo sa bilog na 'o'.",
            strokeCount = 3,
            strokeGuide = listOf("1. Two short vertical strokes above.", "2. Long horizontal stroke left to right."),
            exampleSyllables = listOf("요 (yo)", "교 (gyo)", "뇨 (nyo)", "료 (ryo)"),
            exampleWords = listOf(
                WordExample("요리", "yori", "Cooking / Dish", "Pagluluto / Ulam"),
                WordExample("요즘", "yojeum", "These days / Nowadays", "Kamakailan / Ngayon")
            )
        ),
        HangulCharacter(
            char = "ㅜ",
            name = "우 (u)",
            category = HangulCategory.BASIC_VOWEL,
            englishSound = "u (oo)",
            filipinoSound = "u (tulad sa 'ulan')",
            englishExplanation = "Sounds like 'oo' in 'moon' or 'flute'. Lips pursed forward.",
            filipinoExplanation = "Tunog 'u' tulad sa 'ulan' o 'upuan'. Nakausli ang bilog na labi.",
            mouthTipEn = "Lips rounded tightly like blowing a whistle.",
            mouthTipFil = "Nakasara nang pabilog ang mga labi na parang sisipol.",
            strokeCount = 2,
            strokeGuide = listOf("1. Long horizontal stroke left to right.", "2. Short vertical stroke downwards from the center."),
            exampleSyllables = listOf("우 (u)", "구 (gu)", "누 (nu)", "두 (du)"),
            exampleWords = listOf(
                WordExample("우유", "uyu", "Milk", "Gatas"),
                WordExample("우리", "uri", "We / Our", "Tayo / Atin")
            )
        ),
        HangulCharacter(
            char = "ㅠ",
            name = "유 (yu)",
            category = HangulCategory.BASIC_VOWEL,
            englishSound = "yu (you)",
            filipinoSound = "yu (tulad sa Ingles na 'you')",
            englishExplanation = "Sounds like 'you' in English. Rounded lips with 'y' prefix.",
            filipinoExplanation = "Tunog 'yu' tulad sa Ingles na 'you' o 'yunit'.",
            mouthTipEn = "Glide from 'ee' to rounded 'oo'.",
            mouthTipFil = "Dumulas mula 'i' patungong bilog na 'u'.",
            strokeCount = 3,
            strokeGuide = listOf("1. Long horizontal stroke left to right.", "2. Two short vertical strokes pointing downwards."),
            exampleSyllables = listOf("유 (yu)", "규 (gyu)", "뉴 (nyu)", "류 (ryu)"),
            exampleWords = listOf(
                WordExample("유학", "yuhak", "Studying abroad", "Pag-aaral sa ibang bansa"),
                WordExample("유명", "yumyeong", "Famous", "Sikat / Kilala")
            )
        ),
        HangulCharacter(
            char = "ㅡ",
            name = "으 (eu)",
            category = HangulCategory.BASIC_VOWEL,
            englishSound = "eu",
            filipinoSound = "eu (nakangiting u / lalamunang tunog)",
            englishExplanation = "Unique Korean vowel! Make the 'oo' sound while pulling the corners of your mouth back into a flat smile. No lip rounding!",
            filipinoExplanation = "Natatanging patinig sa Korean! Sabihin ang 'u' habang nakangiti nang pahaba ang labi. Huwag ibilog ang labi!",
            mouthTipEn = "Stretch lips sideways into a flat smile, tongue pulled slightly back.",
            mouthTipFil = "Iunat ang mga labi nang pahalang na parang ngumingiti, hilahin ang dila sa likod.",
            strokeCount = 1,
            strokeGuide = listOf("1. Single clean horizontal line from left to right."),
            exampleSyllables = listOf("으 (eu)", "그 (geu)", "느 (neu)", "드 (deu)"),
            exampleWords = listOf(
                WordExample("음식", "eumsik", "Food", "Pagkain"),
                WordExample("음악", "eumak", "Music", "Musika")
            )
        ),
        HangulCharacter(
            char = "ㅣ",
            name = "이 (i)",
            category = HangulCategory.BASIC_VOWEL,
            englishSound = "i (ee)",
            filipinoSound = "i (tulad sa 'ilaw')",
            englishExplanation = "Sounds like 'ee' in 'see' or 'meet'. Flat smiling lips.",
            filipinoExplanation = "Tunog 'i' tulad sa 'ilaw' o 'isda'. Nakabuka nang pahalang ang labi.",
            mouthTipEn = "Tongue high and forward, lips stretched wide.",
            mouthTipFil = "Nasa itaas at unahan ang dila, nakaunat ang mga labi.",
            strokeCount = 1,
            strokeGuide = listOf("1. Single straight vertical line from top to bottom."),
            exampleSyllables = listOf("이 (i)", "기 (gi)", "니 (ni)", "디 (di)"),
            exampleWords = listOf(
                WordExample("이름", "ireum", "Name", "Pangalan"),
                WordExample("이야기", "iyagi", "Story / Talk", "Kuwento / Usapan")
            )
        )
    )

    val compoundVowels = listOf(
        HangulCharacter(
            char = "ㅐ",
            name = "애 (ae)",
            category = HangulCategory.COMPOUND_VOWEL,
            englishSound = "ae / e",
            filipinoSound = "e (tulad sa 'mesa')",
            englishExplanation = "Sounds like 'e' in 'bed' or 'apple'. In modern Korean, ㅐ and ㅔ sound practically identical.",
            filipinoExplanation = "Tunog 'e' tulad sa 'mesa' o 'pera'. Sa modernong Korean, pareho na halos ang tunog ng ㅐ at ㅔ.",
            mouthTipEn = "Mouth slightly open, jaw slightly lowered.",
            mouthTipFil = "Bahagyang bukas ang bibig, nakababa nang kaunti ang panga.",
            strokeCount = 3,
            strokeGuide = listOf("ㅏ + ㅣ combination."),
            exampleSyllables = listOf("애 (ae)", "개 (gae)", "내 (nae)", "대 (dae)"),
            exampleWords = listOf(
                WordExample("새", "sae", "Bird / New", "Ibon / Bago"),
                WordExample("배", "bae", "Stomach / Pear / Boat", "Tiyan / Peras / Barko")
            )
        ),
        HangulCharacter(
            char = "ㅔ",
            name = "에 (e)",
            category = HangulCategory.COMPOUND_VOWEL,
            englishSound = "e",
            filipinoSound = "e (tulad sa 'eroplano')",
            englishExplanation = "Sounds like 'e' in 'egg'. Practically identical to ㅐ in everyday modern speech.",
            filipinoExplanation = "Tunog 'e' tulad sa 'eroplano' o 'elepante'. Halos pareho sa ㅐ sa pang-araw-araw na pagsasalita.",
            mouthTipEn = "Slightly narrower opening than ㅐ, but indistinguishable to native listeners today.",
            mouthTipFil = "Bahagyang mas makitid kaysa ㅐ ngunit pareho ang pandinig ng mga Koreano ngayon.",
            strokeCount = 3,
            strokeGuide = listOf("ㅓ + ㅣ combination."),
            exampleSyllables = listOf("에 (e)", "게 (ge)", "네 (ne)", "데 (de)"),
            exampleWords = listOf(
                WordExample("네", "ne", "Yes", "Opo / Oo"),
                WordExample("가게", "gage", "Store / Shop", "Tindahan")
            )
        ),
        HangulCharacter(
            char = "ㅒ",
            name = "얘 (yae)",
            category = HangulCategory.COMPOUND_VOWEL,
            englishSound = "yae",
            filipinoSound = "ye (tulad sa 'yes')",
            englishExplanation = "Sounds like 'yeah' in English (glide 'y' + 'ae').",
            filipinoExplanation = "Tunog 'ye' tulad sa Ingles na 'yes'.",
            mouthTipEn = "Glide quickly from 'y' into 'ae'.",
            mouthTipFil = "Mabilis na dumulas mula 'y' patungo sa 'ae'.",
            strokeCount = 4,
            strokeGuide = listOf("ㅑ + ㅣ combination."),
            exampleSyllables = listOf("얘 (yae)", "걔 (gyae)"),
            exampleWords = listOf(
                WordExample("얘기", "yaegi", "Chat / Story (colloquial)", "Kuwentuhan")
            )
        ),
        HangulCharacter(
            char = "ㅖ",
            name = "예 (ye)",
            category = HangulCategory.COMPOUND_VOWEL,
            englishSound = "ye",
            filipinoSound = "ye (tulad sa 'yelo')",
            englishExplanation = "Sounds like 'ye' in 'yes'. Very common polite word for 'Yes' (예).",
            filipinoExplanation = "Tunog 'ye' tulad sa 'yelo'. Ginagamit ding magalang na 'Opo' (예).",
            mouthTipEn = "Glide from 'y' to 'e'.",
            mouthTipFil = "Mabilis na dumaan mula 'y' patungong 'e'.",
            strokeCount = 4,
            strokeGuide = listOf("ㅕ + ㅣ combination."),
            exampleSyllables = listOf("예 (ye)", "계 (gye)", "례 (rye)"),
            exampleWords = listOf(
                WordExample("예", "ye", "Yes (formal)", "Opo (pormal)"),
                WordExample("예술", "yesul", "Art", "Sining")
            )
        ),
        HangulCharacter(
            char = "ㅘ",
            name = "와 (wa)",
            category = HangulCategory.COMPOUND_VOWEL,
            englishSound = "wa",
            filipinoSound = "wa (tulad sa 'watawat')",
            englishExplanation = "Sounds like 'wa' in 'water'. Combination of ㅗ (o) + ㅏ (a).",
            filipinoExplanation = "Tunog 'wa' tulad sa 'watawat'. Pagsasama ng ㅗ + ㅏ.",
            mouthTipEn = "Round lips into 'w' then open into 'ah'.",
            mouthTipFil = "Ibilog ang labi sa 'w' saka ibuka sa 'a'.",
            strokeCount = 4,
            strokeGuide = listOf("ㅗ + ㅏ combined side by side."),
            exampleSyllables = listOf("와 (wa)", "과 (gwa)", "봐 (bwa)"),
            exampleWords = listOf(
                WordExample("사과", "sagwa", "Apple / Apology", "Mansanas / Tawad"),
                WordExample("화요일", "hwayoil", "Tuesday", "Martes")
            )
        ),
        HangulCharacter(
            char = "ㅙ",
            name = "왜 (wae)",
            category = HangulCategory.COMPOUND_VOWEL,
            englishSound = "wae",
            filipinoSound = "we (tulad sa 'waiter')",
            englishExplanation = "Sounds like 'wae' in 'wet' or 'wait'. Pronounced identically to ㅚ and ㅞ in modern Korean.",
            filipinoExplanation = "Tunog 'we' tulad sa Ingles na 'wet'. Bakit (왜) ang isa sa pinakatanyag na gamit nito.",
            mouthTipEn = "Lips start rounded and slide into 'ae'.",
            mouthTipFil = "Mula bilog na labi patungo sa 'ae'.",
            strokeCount = 5,
            strokeGuide = listOf("ㅗ + ㅐ combination."),
            exampleSyllables = listOf("왜 (wae)", "돼 (dwae)"),
            exampleWords = listOf(
                WordExample("왜", "wae", "Why?", "Bakit?"),
                WordExample("돼지", "dwaeji", "Pig", "Baboy")
            )
        ),
        HangulCharacter(
            char = "ㅚ",
            name = "외 (oe)",
            category = HangulCategory.COMPOUND_VOWEL,
            englishSound = "oe (sounds like 'we')",
            filipinoSound = "we (tulad sa 'welga')",
            englishExplanation = "Despite the spelling (ㅗ + ㅣ), it is pronounced like 'we' in 'west' in modern standard Korean.",
            filipinoExplanation = "Kahit isinusulat bilang ㅗ + ㅣ, ang tunog nito ngayon ay parang 'we' tulad sa 'west'.",
            mouthTipEn = "Pronounce like 'way' or 'we'.",
            mouthTipFil = "Bigkasin na parang 'we'.",
            strokeCount = 3,
            strokeGuide = listOf("ㅗ + ㅣ combination."),
            exampleSyllables = listOf("외 (oe)", "회 (hoe)", "퇴 (toe)"),
            exampleWords = listOf(
                WordExample("외국", "oeguk", "Foreign country", "Ibang bansa"),
                WordExample("회사", "hoesa", "Company / Office", "Kumpanya / Opisina")
            )
        ),
        HangulCharacter(
            char = "ㅝ",
            name = "워 (wo)",
            category = HangulCategory.COMPOUND_VOWEL,
            englishSound = "wo",
            filipinoSound = "wo (tulad sa 'wonder')",
            englishExplanation = "Sounds like 'wo' in 'won' or 'wonder'. Combination of ㅜ (u) + ㅓ (eo).",
            filipinoExplanation = "Tunog 'wo' tulad sa Ingles na 'water' o 'wonderful'. Pagsasama ng ㅜ + ㅓ.",
            mouthTipEn = "Round lips into 'w' glide, then unround into 'eo'.",
            mouthTipFil = "Bilog na labi patungo sa maluwag na 'eo'.",
            strokeCount = 4,
            strokeGuide = listOf("ㅜ + ㅓ combination."),
            exampleSyllables = listOf("워 (wo)", "뭐 (mwo)", "줘 (jwo)"),
            exampleWords = listOf(
                WordExample("뭐", "mwo", "What?", "Ano?"),
                WordExample("원", "won", "Korean Won (currency)", "Korean Won (pera)")
            )
        ),
        HangulCharacter(
            char = "ㅞ",
            name = "웨 (we)",
            category = HangulCategory.COMPOUND_VOWEL,
            englishSound = "we",
            filipinoSound = "we (tulad sa 'wedding')",
            englishExplanation = "Sounds like 'we' in 'wedding'. Pronounced virtually identical to ㅙ and ㅚ.",
            filipinoExplanation = "Tunog 'we' tulad sa 'wedding'. Halos katulad din ng ㅙ at ㅚ.",
            mouthTipEn = "Quick glide from 'w' into 'e'.",
            mouthTipFil = "Mabilis na dumaan mula 'w' patungo sa 'e'.",
            strokeCount = 5,
            strokeGuide = listOf("ㅜ + ㅔ combination."),
            exampleSyllables = listOf("웨 (we)", "궤 (gwe)"),
            exampleWords = listOf(
                WordExample("웨딩", "weding", "Wedding", "Kasal / Kasalan")
            )
        ),
        HangulCharacter(
            char = "ㅟ",
            name = "위 (wi)",
            category = HangulCategory.COMPOUND_VOWEL,
            englishSound = "wi (wee)",
            filipinoSound = "wi (tulad sa 'wika')",
            englishExplanation = "Sounds like 'we' in 'week' or 'win'. Combination of ㅜ (u) + ㅣ (i).",
            filipinoExplanation = "Tunog 'wi' tulad sa 'wika' o 'watawat'. Pagsasama ng ㅜ + ㅣ.",
            mouthTipEn = "Pucker lips for 'w' then smile wide for 'ee'.",
            mouthTipFil = "Nakausli ang labi sa 'w' saka ngumiti sa 'i'.",
            strokeCount = 3,
            strokeGuide = listOf("ㅜ + ㅣ combination."),
            exampleSyllables = listOf("위 (wi)", "귀 (gwi)", "쉬 (swi)"),
            exampleWords = listOf(
                WordExample("위", "wi", "Above / Stomach", "Itaas / Tiyan"),
                WordExample("귀", "gwi", "Ear", "Tainga")
            )
        ),
        HangulCharacter(
            char = "ㅢ",
            name = "의 (ui)",
            category = HangulCategory.COMPOUND_VOWEL,
            englishSound = "ui",
            filipinoSound = "ui (eu + i)",
            englishExplanation = "Combination of ㅡ (eu) + ㅣ (i). Note: When used as the possessive particle 'of', it is pronounced as '에 (e)'. At word starts, it sounds like 'eu-ee'.",
            filipinoExplanation = "Pagsasama ng ㅡ (eu) at ㅣ (i). Kapag ginamit bilang katagang 'ng' (possessive), binibigkas ito bilang 'e'.",
            mouthTipEn = "Start with flat 'eu' and glide forward to 'ee'.",
            mouthTipFil = "Magsimula sa nakangiting 'eu' at dumulas sa 'i'.",
            strokeCount = 2,
            strokeGuide = listOf("ㅡ + ㅣ combination."),
            exampleSyllables = listOf("의 (ui)", "희 (hui)"),
            exampleWords = listOf(
                WordExample("의사", "uisa", "Doctor", "Doktor"),
                WordExample("의자", "uija", "Chair", "Upuan")
            )
        )
    )

    val batchimRules = listOf(
        BatchimRule(
            title = "ㄱ Representative Sound [k]",
            characters = "ㄱ, ㅋ, ㄲ, ㄳ, ㄺ",
            representativeSound = "[k] (unreleased k)",
            explanationEn = "All these final consonants are pronounced as a stopped, unreleased [k] at the end of a syllable before a pause or consonant.",
            explanationFil = "Lahat ng mga ito ay binibigkas bilang pinigilang [k] sa dulo ng pantig bago ang isa pang katinig o paghinto.",
            examples = listOf(
                WordExample("책", "chaek", "Book", "Aklat"),
                WordExample("부엌", "bueok", "Kitchen", "Kusina"),
                WordExample("밖", "bak", "Outside", "Labas")
            )
        ),
        BatchimRule(
            title = "ㄴ Representative Sound [n]",
            characters = "ㄴ, ㄵ, ㄶ",
            representativeSound = "[n]",
            explanationEn = "Pronounced clearly as [n], with the tongue pressed against the upper gum ridge.",
            explanationFil = "Malinaw na binibigkas bilang [n], nakalapat ang dila sa itaas na gilagid.",
            examples = listOf(
                WordExample("눈", "nun", "Eye / Snow", "Mata / Niyebe"),
                WordExample("문", "mun", "Door", "Pinto")
            )
        ),
        BatchimRule(
            title = "ㄷ Representative Sound [t]",
            characters = "ㄷ, ㅅ, ㅆ, ㅈ, ㅊ, ㅌ, ㅎ",
            representativeSound = "[t] (unreleased t)",
            explanationEn = "Remarkable rule: 7 different consonants all simplify to an unreleased [t] when resting in the final batchim position!",
            explanationFil = "Kahanga-hangang tuntunin: 7 magkakaibang katinig ang lahat ay nagiging [t] kapag nasa posisyong batchim sa dulo!",
            examples = listOf(
                WordExample("옷", "ot", "Clothes", "Damit"),
                WordExample("낮", "nat", "Daytime", "Araw / Tanghali"),
                WordExample("꽃", "kkot", "Flower", "Bulaklak"),
                WordExample("끝", "kkeut", "End / Finish", "Wakas / Dulo")
            )
        ),
        BatchimRule(
            title = "ㄹ Representative Sound [l]",
            characters = "ㄹ, ㄼ, ㄽ, ㄾ, ㅀ",
            representativeSound = "[l]",
            explanationEn = "In the final position, ㄹ becomes a soft, clear [l] like in 'feel' or 'bell'.",
            explanationFil = "Sa dulo ng pantig, ang ㄹ ay nagiging malambot na [l] tulad sa 'asal' o 'buntal'.",
            examples = listOf(
                WordExample("물", "mul", "Water", "Tubig"),
                WordExample("달", "dal", "Moon / Month", "Buwan"),
                WordExample("발", "bal", "Foot", "Paa")
            )
        ),
        BatchimRule(
            title = "ㅁ Representative Sound [m]",
            characters = "ㅁ, ㄻ",
            representativeSound = "[m]",
            explanationEn = "Lips close completely, sound hums through the nose.",
            explanationFil = "Nakasara ang mga labi habang lumalabas ang tunog sa ilong.",
            examples = listOf(
                WordExample("봄", "bom", "Spring season", "Tagsibol"),
                WordExample("밤", "bam", "Night / Chestnut", "Gabi / Kastanyas")
            )
        ),
        BatchimRule(
            title = "ㅂ Representative Sound [p]",
            characters = "ㅂ, ㅍ, ㅄ, ㄿ",
            representativeSound = "[p] (unreleased p)",
            explanationEn = "Lips close shut to stop the air, resulting in an unreleased [p].",
            explanationFil = "Nakasara ang mga labi para pigilan ang hangin, na lumilikha ng [p].",
            examples = listOf(
                WordExample("집", "jip", "House / Home", "Bahay / Tirahan"),
                WordExample("밥", "bap", "Rice / Meal", "Kanin / Pagkain"),
                WordExample("앞", "ap", "Front", "Harap")
            )
        ),
        BatchimRule(
            title = "ㅇ Representative Sound [ng]",
            characters = "ㅇ",
            representativeSound = "[ng]",
            explanationEn = "At the bottom, ㅇ produces the resonant [ng] sound like in 'king' or 'song'.",
            explanationFil = "Sa ilalim ng pantig, ang ㅇ ay nagbibigay ng tunog na [ng] tulad sa 'singsing'.",
            examples = listOf(
                WordExample("강", "gang", "River", "Ilog"),
                WordExample("공항", "gonghang", "Airport", "Paliparan")
            )
        )
    )

    fun getAllCharacters(): List<HangulCharacter> {
        return basicConsonants + doubleConsonants + basicVowels + compoundVowels
    }
}
