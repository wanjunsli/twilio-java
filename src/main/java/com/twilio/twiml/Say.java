package com.twilio.twiml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * TwiML wrapper for @see https://www.twilio.com/docs/api/twiml/say.
 */
@XmlRootElement(name = "Say")
public class Say extends TwiML {

    public enum Voice {
        MAN("man"),
        WOMAN("woman"),
        ALICE("alice");

        private final String value;

        Voice(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }

    public enum Language {
        EN("en"),
        EN_GB("en-gb"),
        EN_AU("en-AU"),
        EN_CA("en-GB"),
        EN_IN("en-IN"),
        EN_US("en-US"),
        ES("es"),
        ES_ES("es-ES"),
        ES_MX("es-MX"),
        FR("fr"),
        FR_CA("fr-CA"),
        FR_FR("fr-FR"),
        DE("de"),
        DE_DE("de-DE"),
        DA_DK("da-DK"),
        CA_ES("ca-ES"),
        FI_FI("fi-FI"),
        IT_IT("it-IT"),
        JA_JP("ja-JP"),
        KO_KR("ko-KR"),
        NB_NO("nb-NO"),
        NL_NL("nl-NL"),
        PL_PL("pl-PL"),
        PT_BR("pt-BR"),
        PT_PT("pt-PT"),
        RU_RU("ru-RU"),
        SV_SE("sv-SE"),
        ZH_CN("zh-CN"),
        ZH_HK("zh-HK"),
        ZH_TW("zh-TW");

        private final String value;

        Language(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }

    @XmlAttribute
    private final Integer loop;

    @XmlAttribute
    @XmlJavaTypeAdapter(TwiML.ToStringAdapter.class)
    private final Language language;

    @XmlAttribute
    @XmlJavaTypeAdapter(TwiML.ToStringAdapter.class)
    private final Voice voice;

    @XmlValue
    private final String body;

    // For XML Serialization
    private Say() {
        this(new Builder(null));
    }

    private Say(Builder b) {
        this.loop = b.loop;
        this.language = b.language;
        this.voice = b.voice;
        this.body = b.body;
    }

    public Integer getLoop() {
        return loop;
    }

    public Language getLanguage() {
        return language;
    }

    public Voice getVoice() {
        return voice;
    }

    public String getBody() {
        return body;
    }

    public static class Builder {
        private Integer loop;
        private Language language;
        private Voice voice;
        private String body;

        public Builder(String body) {
            this.body = body;
        }

        public Builder loop(int loop) {
            this.loop = loop;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public Builder voice(Voice voice) {
            this.voice = voice;
            return this;
        }

        public Say build() {
            return new Say(this);
        }
    }
}
