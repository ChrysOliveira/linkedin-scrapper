package com.example.linkedin_scrapper.domains.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ExperienceDTO {
    private List<ExperienceData> included;

    @Getter
    @Setter
    @ToString
    public static class ExperienceData {
        private Components components;

        @Getter
        @Setter
        @ToString
        public static class Components{
            private List<Elements> elements;

            @Getter
            @Setter
            @ToString
            public static class Elements{
                @JsonProperty("components")
                private ComponentsInner componentsInner;

                @Getter
                @Setter
                @ToString
                public static class ComponentsInner{
                    private EntityComponent entityComponent;

                    @Getter
                    @Setter
                    @ToString
                    public static  class EntityComponent{
                        @JsonProperty("titleV2")
                        private Title title;
                        private Subtitle subtitle;
                        private Caption caption;
                        private Metadata metadata;
                        private SubComponents subComponents;

                        @Getter
                        @Setter
                        @ToString
                        public static class SubComponents{
                            @JsonProperty("components")
                            private List<ComponentsList> componentsLists;

                            @Getter
                            @Setter
                            @ToString
                            public static class ComponentsList{
                                private InnerComponent components;

                                @Getter
                                @Setter
                                @ToString
                                public static class InnerComponent{
                                    @JsonProperty("fixedListComponent")
                                    private FixedListComp fixedListComp;

                                    @Getter
                                    @Setter
                                    @ToString
                                    public static class FixedListComp{
                                        private List<InnerComponentFixedList> components;

                                        @Getter
                                        @Setter
                                        @ToString
                                        public static class InnerComponentFixedList{
                                            private InnerComponentFixed components;

                                            @Getter
                                            @Setter
                                            @ToString
                                            public static class InnerComponentFixed{
                                                private Title textComponent;
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        @Getter
                        @Setter
                        @ToString
                        public static class Metadata{
                            private String text;
                        }

                        @Getter
                        @Setter
                        @ToString
                        public static class Subtitle{
                            private String text;
                        }

                        @Getter
                        @Setter
                        @ToString
                        public static class Caption{
                            private String text;
                        }


                        @Getter
                        @Setter
                        @ToString
                        public static  class Title{
                            private Text text;

                            @Getter
                            @Setter
                            @ToString
                            public static  class Text{
                                private String text;
                            }
                        }
                    }
                }
            }
        }
    }
}
