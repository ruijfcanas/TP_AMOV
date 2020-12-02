package pt.isec.tp_amov.fragments

import android.content.Context
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import pt.isec.tp_amov.R
import pt.isec.tp_amov.interfaces.ConfigOptionsInterface

class FragmentConfigOpts : Fragment() {
    lateinit var lvList: ListView
    lateinit var adapter: ArrayAdapter<String>
    private var configsOptions = ArrayList<String>()
    val TAG = "FragmentChangeLanguage"

    var actConfig : ConfigOptionsInterface? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        actConfig = context as? ConfigOptionsInterface
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(TAG, "onCreateView1: ")
        val view = inflater.inflate(R.layout.fragment_choose_opt, container, false)
        lvList = view.findViewById(R.id.lvConfigList)
        adapter = ArrayAdapter(view.context, android.R.layout.simple_selectable_list_item, configsOptions)
        lvList.adapter = adapter
        fillConfigs()
        prepareOptions()
        return view
    }

    private fun fillConfigs(){
        configsOptions.add(getString(R.string.optManageUnits))
        configsOptions.add(getString(R.string.optManageCategories))
        configsOptions.add(getString(R.string.optChangeLang))
    }

    private fun prepareOptions(){
        lvList.setOnItemClickListener { parent, view, position, id ->
            when(position){
                0 -> actConfig?.SwapToChangeUnit()
                1 -> actConfig?.SwapToChangeCategory()
                2 -> actConfig?.SwapToChangeLanguage()
            }
        }
    }
}