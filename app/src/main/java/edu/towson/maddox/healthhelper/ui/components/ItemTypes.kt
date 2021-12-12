package edu.towson.maddox.healthhelper.ui.components

enum class ItemTypes {
        umed{
                override fun toString(): String
                {
                        return "Medications"
                }
            },
        uc{
                override fun toString(): String
                {
                        return "Conditions"
                }
        },
        urf{
                override fun toString(): String
                {
                        return "Risk Factors"
                }
        },
        us{
                override fun toString(): String
                {
                        return "Symptoms"
                }
        }, uv{
                override fun toString(): String
                {
                        return "Vital Signs"
                }
        },
        numed{
                override fun toString(): String
                {
                        return "New Medication"
                }
        },
        nuc{
                override fun toString(): String
                {
                        return "New Condition"
                }
        },
        nurf{
                override fun toString(): String
                {
                        return "New Risk Factor"
                }
        },
        nus{
                override fun toString(): String
                {
                        return "New Symptom"
                }
        },
        nuv{
                override fun toString(): String
                {
                        return "New Vital Sign"
                }
        }
}