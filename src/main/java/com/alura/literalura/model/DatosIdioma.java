package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum DatosIdioma {
    ABJASO("ab"),
    AFAR("aa"),
    AFRIKAANS("af"),
    AIMARA("ay"),
    AKANO("ak"),
    ALBANES("sq"),
    ALEMAN("de"),
    AMARICO("am"),
    ARABE("ar"),
    ARAGONES("an"),
    ARMENIO("hy"),
    ASAMES("as"),
    AVAR("av"),
    AVESTICO("ae"),
    AZERI("az"),
    BAMBARA("bm"),
    BASKIR("ba"),
    BENGALI("bn"),
    BHOJPURI("bh"),
    BIELORRUSO("be"),
    BIRMANO("my"),
    BISLAMA("bi"),
    BOSNIO("bs"),
    BRETON("br"),
    BULGARO("bg"),
    CACHEMIRO("ks"),
    CAMBOYANO("km"),
    CANARES("kn"),
    CATALAN("ca"),
    CHAMORRO("ch"),
    CHECHENO("ce"),
    CHECO("cs"),
    CHICHEWA("ny"),
    CHINO("zh"),
    CHUAN("za"),
    CHUVASIO("cv"),
    CINGALES("si"),
    COREANO("ko"),
    CORNICO("kw"),
    CORSO("co"),
    CREE("cr"),
    CROATA("hr"),
    DANES("da"),
    DZONGKHA("dz"),
    ESLAVO("cu"),
    ESLOVACO("sk"),
    ESLOVENO("sl"),
    CASTELLANO("es"),
    ESPERANTO("eo"),
    ESTONIO("et"),
    EWE("ee"),
    FEROES("fo"),
    FIJIANO("fj"),
    FINES("fi"),
    FRANCES("fr"),
    FRISON("fy"),
    FULA("ff"),
    GAELICO("gd"),
    GALES("cy"),
    GALLEGO("gl"),
    GEORGIANO("ka"),
    GRIEGO("e"),
    GROENLANDES("k"),
    GUARANI("gn"),
    GUYARATI("gu"),
    HAITIANO("ht"),
    HAUSA("ha"),
    HEBREO("he"),
    HERERO("hz"),
    HINDI("hi"),
    HIRI("ho"),
    HUNGARO("hu"),
    IDO("io"),
    IGBO("ig"),
    INDONESIO("id"),
    INGLES("en"),
    INTERLINGUA("ia"),
    INUKTITUT("iu"),
    INUPIAQ("ik"),
    IRLANDES("ga"),
    ISLANDES("is"),
    ITALIANO("it"),
    JAPONES("ja"),
    JAVANES("jv"),
    KANURI("kr"),
    KAZAJO("kk"),
    KIKUYU("ki"),
    KIRGUIS("ky"),
    KIRUNDI("rn"),
    KOMI("kv"),
    KONGO("kg"),
    KUANYAMA("kj"),
    KURDO("ku"),
    LAO("lo"),
    LATIN("la"),
    LETON("lv"),
    LIMBURGUES("li"),
    LINGALA("ln"),
    LITUANO("lt"),
    LUBA("lu"),
    LUGANDA("lg"),
    LUXEMBURGUES("lb"),
    MACEDONIO("mk"),
    MALAYALAM("ml"),
    MALAYO("ms"),
    MALDIVO("dv"),
    MALGACHE("mg"),
    MALTES("mt"),
    MANES("gv"),
    MAORI("mi"),
    MARATI("mr"),
    MARSHALES("mh"),
    MOLDAVO("mo"),
    MONGOL("mn"),
    NAURUANO("na"),
    NAVAJO("nv"),
    NDEBELE_DEL_NORTE("nd"),
    NDEBELE_DEL_SUR("nr"),
    NDONGA("ng"),
    NEERLANDES("nl"),
    NEPALI("ne"),
    NORUEGO("no"),
    NORUEGO_BOKMÅL("nb"),
    NYNORSK("nn"),
    OCCIDENTAL("ie"),
    OCCITANO("oc"),
    OJIBWA("oj"),
    ORIYA("or"),
    OROMO("om"),
    OSETICO("os"),
    PALI("pi"),
    PANYABI("pa"),
    PASTU("ps"),
    PERSA("fa"),
    POLACO("pl"),
    PORTUGUES("pt"),
    QUECHUA("qu"),
    RETORROMANICO("rm"),
    RUANDES("rw"),
    RUMANO("ro"),
    RUSO("ru"),
    SAMI("se"),
    SAMOANO("sm"),
    SANGO("sg"),
    SANSCRITO("sa"),
    SARDO("sc"),
    SERBIO("sr"),
    SESOTHO("st"),
    SETSUANA("tn"),
    SHONA("sn"),
    SINDHI("sd"),
    SOMALI("so"),
    SUAJILI("sw"),
    SUAZI("ss"),
    SUECO("sv"),
    SUNDANES("su"),
    TAGALO("tl"),
    TAHITIANO("ty"),
    TAILANDES("th"),
    TAMIL("ta"),
    TARTARO("tt"),
    TAYIKO("tg"),
    TELUGU("te"),
    TIBETANO("bo"),
    TIGRINIA("ti"),
    TONGANO("to"),
    TSONGA("ts"),
    TURCO("tr"),
    TURCOMANO("tk"),
    TWI("tw"),
    UCRANIANO("uk"),
    UIGUR("ug"),
    URDU("ur"),
    UZBEKO("uz"),
    VALON("wa"),
    VASCUENCE("eu"),
    VENDA("ve"),
    VIETNAMITA("vi"),
    VOLAPÜK("vo"),
    WOLOF("wo"),
    XHOSA("xh"),
    YI_DE_SICHUAN("ii"),
    YIDISH("yi"),
    YORUBA("yo"),
    ZULU("zu");

    private String idioma;

    DatosIdioma(String idioma) {
        this.idioma = idioma;
    }

    @JsonCreator
    public static DatosIdioma fromString(String text) {
        for (DatosIdioma idioma : DatosIdioma.values()) {
            if (idioma.idioma.equalsIgnoreCase(text)) {
                return idioma;
            }
        }
        throw new IllegalArgumentException("Idioma no encontrado: " + text);
    }

    public Object idioma() {
        return idioma;
    }
}
