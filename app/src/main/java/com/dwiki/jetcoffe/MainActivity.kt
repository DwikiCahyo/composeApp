package com.dwiki.jetcoffe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dwiki.jetcoffe.model.Category
import com.dwiki.jetcoffe.model.dummyCategory
import com.dwiki.jetcoffe.ui.components.CategoryItem
import com.dwiki.jetcoffe.ui.components.SearchBar
import com.dwiki.jetcoffe.ui.components.SectionText
import com.dwiki.jetcoffe.ui.theme.JetCoffeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetCoffeTheme {
                JetCoffeeApp()
            }
        }
    }
}

@Composable
fun JetCoffeeApp(){
    Column {
        Banner()
        SectionText(stringResource(R.string.section_category))
        CategoryRow()
    }
}
@Composable
fun Banner(
    modifier: Modifier = Modifier
){
    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.banner),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
        )
        SearchBar()
    }
}

@Composable
fun CategoryRow(
    modifier: Modifier = Modifier
){
   LazyRow(
       horizontalArrangement = Arrangement.spacedBy(8.dp),
       contentPadding = PaddingValues(horizontal = 16.dp),
       modifier = modifier
   ){
       items(dummyCategory, key = { it.textCategory }) { category ->
           CategoryItem(category)
       }
   }
}

@Preview(showBackground = true)
@Composable
fun CategoryRowPreview(){
    JetCoffeTheme {
        CategoryRow()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetCoffeTheme {
        JetCoffeeApp()
    }
}


