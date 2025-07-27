package com.adriandeseta.cv.ui.adriandeseta.experience

import com.adriandeseta.cv.ui.adriandeseta.experience.dto.ExperienceData

object ExperienceProvider {
    val experienceList = listOf(
        ExperienceData(
            period = "2024 - Actualidad",
            company = "Eldar",
            role = "Mobile Engineer - Android",
            responsibilities = listOf("Santander POS", "Eldar Mpos Mobile")
        ),
        ExperienceData(
            period = "2020 - 2023",
            company = "Mercado Libre",
            role = "Software Development SSr. Analyst",
            responsibilities = listOf(
                "Desarrollador front-end\n" +
                        "mobile (Kotlin) en la vertical\n" +
                        "de pagos de servicios en\n" +
                        "Mercado pago.\n" +
                        "Desarrollo de nuevos flujos\n" +
                        "y bugfixing."
            )
        ),
        ExperienceData(
            period = "2014 - 2020",
            company = "Lagash",
            role = "Sr. UI Developer",
            responsibilities = listOf("Tenaris", "Claro video", "Banco Santander")
        ),
        ExperienceData(
            period = "2011 - 2013",
            company = "Avatar",
            role = "Web developer",
            responsibilities = listOf("Coca Cola", "Purina", "Natura")
        )
    )
}
