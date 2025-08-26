package com.example.kotlincoroutine

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TopCompanyGrid : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.top_company_grid)

        val category = intent.getStringExtra("category") ?: "Top Companies"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        // Companies based on category
        val companies = when (category) {
            "Android Company" -> listOf(
                Company("Google", "Android OS creator", "$500B", R.mipmap.ic_launcher),
                Company("Samsung", "Smartphones leader", "$300B", R.mipmap.ic_launcher),
                Company("OnePlus", "Premium smartphones", "$50B", R.mipmap.ic_launcher),
                Company("Xiaomi", "Budget smartphones", "$80B", R.mipmap.ic_launcher),
                Company("Oppo", "Innovative designs", "$60B", R.mipmap.ic_launcher),
                Company("Vivo", "Camera phones", "$70B", R.mipmap.ic_launcher),
                Company("Realme", "Affordable tech", "$40B", R.mipmap.ic_launcher),
                Company("Motorola", "Classic phones", "$30B", R.mipmap.ic_launcher),
                Company("Sony", "Premium devices", "$90B", R.mipmap.ic_launcher),
                Company("LG", "Electronics giant", "$100B", R.mipmap.ic_launcher)
            )
            "iOS Company" -> listOf(
                Company("Apple", "iPhone maker", "$2T", R.mipmap.ic_launcher),
                Company("Foxconn", "Manufacturer", "$200B", R.mipmap.ic_launcher),
                Company("Pegatron", "Assembly partner", "$180B", R.mipmap.ic_launcher),
                Company("Wistron", "Production partner", "$120B", R.mipmap.ic_launcher),
                Company("TSMC", "Chipmaker", "$500B", R.mipmap.ic_launcher),
                Company("Broadcom", "Chips supplier", "$150B", R.mipmap.ic_launcher),
                Company("Corning", "Glass supplier", "$50B", R.mipmap.ic_launcher),
                Company("Dialog Semi", "Semiconductors", "$20B", R.mipmap.ic_launcher),
                Company("Qualcomm", "Mobile chips", "$250B", R.mipmap.ic_launcher),
                Company("Luxshare", "Component maker", "$40B", R.mipmap.ic_launcher)
            )
            "React Company" -> listOf(
                Company("Meta", "React creator", "$900B", R.mipmap.ic_launcher),
                Company("Netflix", "Streaming giant", "$250B", R.mipmap.ic_launcher),
                Company("Airbnb", "Travel platform", "$80B", R.mipmap.ic_launcher),
                Company("Uber", "Ride-sharing", "$70B", R.mipmap.ic_launcher),
                Company("Dropbox", "Cloud storage", "$10B", R.mipmap.ic_launcher),
                Company("Pinterest", "Social media", "$40B", R.mipmap.ic_launcher),
                Company("Shopify", "E-commerce", "$120B", R.mipmap.ic_launcher),
                Company("Discord", "Chat platform", "$15B", R.mipmap.ic_launcher),
                Company("Reddit", "Community forums", "$10B", R.mipmap.ic_launcher),
                Company("Atlassian", "Dev tools", "$50B", R.mipmap.ic_launcher)
            )
            "Full Stack" -> listOf(
                Company("Google", "Tech giant", "$1T", R.mipmap.ic_launcher),
                Company("Microsoft", "Cloud & software", "$2T", R.mipmap.ic_launcher),
                Company("Amazon", "E-commerce & cloud", "$1.5T", R.mipmap.ic_launcher),
                Company("Facebook", "Social network", "$900B", R.mipmap.ic_launcher),
                Company("IBM", "IT services", "$120B", R.mipmap.ic_launcher),
                Company("Accenture", "Consulting", "$180B", R.mipmap.ic_launcher),
                Company("Infosys", "IT services", "$90B", R.mipmap.ic_launcher),
                Company("Wipro", "Tech services", "$80B", R.mipmap.ic_launcher),
                Company("TCS", "Global IT", "$150B", R.mipmap.ic_launcher),
                Company("Capgemini", "Consulting", "$100B", R.mipmap.ic_launcher)
            )
            else -> listOf()
        }

        // Set page title
        val pageTitle = findViewById<TextView>(R.id.pageTitle)
        pageTitle.text = category

        // Attach adapter
        recyclerView.adapter = CompanyAdapter(companies)
    }
}
