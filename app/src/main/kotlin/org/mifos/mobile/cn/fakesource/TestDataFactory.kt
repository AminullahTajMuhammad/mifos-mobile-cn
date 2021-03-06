package org.mifos.mobile.cn.fakesource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import java.io.InputStreamReader

class TestDataFactory {

    /**
     * Note : This Generic Method DeSerialize Both Object and List Type Json in POJO
     *
     *
     * Note : Do Not use Array [] in POJO classes for of any element initialization,
     * Use Instead ArrayList.
     *
     * @param listModel Class of the List Model
     * @param jsonName  Name of the Json in resources
     * @param <T>       return type
     * @return Return the List of the listModel by Deserializing the Json of resources
     * @Example of Deserializing List Type Json
     *
     *
     * TestDataFactory mTestDataFactory = new TestDataFactory();
     *
     *
     * List<Object> listObject = mTestDataFactory.convertJsonToDataObject(
     * new TypeToken<List></List><Object>>(){}, "ListObject.json")
     * @Example Of Deserializing Object Type Json
     *
     *
     * Object object = mTestDataFactory.convertJsonToDataObject(
     * new TypeToken<Object>(){}, "Object.json")
    </Object></Object></Object></T> */
    fun <T> convertJsonToDataObject(listModel: TypeToken<T>, jsonName: String): T {
        val inputStream = this.javaClass.classLoader.getResourceAsStream(jsonName)
        val jsonReader = JsonReader(InputStreamReader(inputStream))
        return Gson().fromJson(jsonReader, listModel.type)
    }

    /**
     * Note : This Generic Method DeSerialize Both Object and List Type Json in POJO
     *
     *
     * Note : Do Not use Array [] in POJO classes for of any element initialization,
     * Use Instead ArrayList.
     *
     * @param listModel Class of the List Model
     * @param jsonName  Name of the Json in resources
     * @param <T>       return type
     * @return Return the List of the listModel by Deserializing the Json of resources
     * @Example of Deserializing List Type Json
     *
     *
     * TestDataFactory mTestDataFactory = new TestDataFactory();
     *
     *
     * List<Object> listObject = mTestDataFactory.getListTypePojo(
     * new TypeToken<List></List><Object>>(){}, "ListObject.json")
     * @Example Of Deserializing Object Type Json
     *
     *
     * Object object = mTestDataFactory.getListTypePojo(
     * new TypeToken<Object>(){}, "Object.json")
    </Object></Object></Object></T> */
    fun <T> getListTypePojo(listModel: TypeToken<T>, jsonName: String): T {

        val inputStreamReader = this.javaClass.classLoader?.getResourceAsStream(jsonName)
        val reader = JsonReader(InputStreamReader(inputStreamReader))
        return Gson().fromJson(reader, listModel.type)

    }



    /**
     * Note : This Generic Method DeSerialize Only Json Object in POJO
     *
     *
     * Note : Do Not use Array [] in POJO classes for of any element initialization,
     * Use Instead ArrayList.
     *
     * @param model    Class of the Model of the Pojo
     * @param jsonName Name of Json file in test/resource
     * @param <T>      Return type
     * @return Return the Object Type model by Deserialize the Json of resources
     * @Example Of Deserialize Object Type Json
     *
     *
     * Object object = mTestDataFactory.getListTypePojo(
     * new TypeToken<Object>(){}, "Object.json")
    </Object></T> */
    fun <T> getObjectTypePojo(model: Class<T>, jsonName: String): LiveData<T> {
        val `in` = javaClass.classLoader.getResourceAsStream(jsonName)
        val reader = JsonReader(InputStreamReader(`in`))
        val result = MutableLiveData<T>()
        result.value = Gson().fromJson(reader,model)
        return result
    }
}