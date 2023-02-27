package com.hamza.delivertiptop.ui.dialogFragments.chooseMediaDialogFragment

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.hamza.delivertiptop.R
import com.hamza.delivertiptop.constant.Constants.CAMERA_PICKER_REQUEST_CODE
import com.hamza.delivertiptop.constant.Constants.IMAGE_PICKER_REQUEST_CODE
import com.hamza.delivertiptop.constant.Constants.VIDEO_CAMERA_PICKER_REQUEST_CODE
import com.hamza.delivertiptop.constant.Constants.VIDEO_GALLERY_PICKER_REQUEST_CODE
import com.hamza.delivertiptop.databinding.FragmentDialogChooserBinding
import com.hamza.delivertiptop.helper.StringHelper
import com.hamza.delivertiptop.ui.base.BaseDialogFragment
import com.hamza.delivertiptop.utils.CommonKeys
import com.hamza.delivertiptop.utils.DialogUtils
import com.hamza.delivertiptop.utils.Log
import com.hamza.delivertiptop.utils.PermissionUtils
import gun0912.tedimagepicker.builder.TedImagePicker
import gun0912.tedimagepicker.builder.type.MediaType
import pl.aprilapps.easyphotopicker.EasyImage
import pl.aprilapps.easyphotopicker.MediaSource

class ChooseMediaDialogFragment : BaseDialogFragment() {
    private lateinit var binding: FragmentDialogChooserBinding
    private lateinit var viewModel: ChooseMediaDialogFragmentViewModel
    private var callBack: CallBack? = null
    var easyImage: EasyImage? = null

    companion object {

        private const val TAG = "ChooserDialogFragment"

        @JvmStatic
        fun newInstance(
            viewType: Int, limitOfPickImage: Int,
            callBack: CallBack
        ): ChooseMediaDialogFragment {
            val fragment = ChooseMediaDialogFragment()
            val bundle = Bundle()
            bundle.putInt(CommonKeys.KEY_DATA, viewType)
            bundle.putInt(CommonKeys.KEY_LIMIT, limitOfPickImage)
            fragment.arguments = bundle
            fragment.setCallBack(callBack)
            return fragment
        }
    }

    private fun setCallBack(callBack: CallBack) {
        this.callBack = callBack
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (dialog != null && dialog?.window != null) {
            dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        }
        viewModel = ViewModelProvider(this)[ChooseMediaDialogFragmentViewModel::class.java]
        val args = arguments
        if (args != null && !args.isEmpty) {
            viewModel.viewType = args.getInt(CommonKeys.KEY_DATA)
            viewModel.limitOfPickImage = args.getInt(CommonKeys.KEY_LIMIT)
        }
        binding = FragmentDialogChooserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when (viewModel.viewType) {
            CommonKeys.TYPE_PHOTO -> typePhoto()
            CommonKeys.TYPE_VIDEO -> typeVideo()
        }
        createEasyImgObj()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.e(TAG, "onActivityResult: Dialogue receive")
        easyImage?.handleActivityResult(
            requestCode, resultCode, data, requireActivity(),
            object : EasyImage.Callbacks {
                override fun onImagePickerError(error: Throwable, source: MediaSource) {
                    error.printStackTrace()
                }

                override fun onMediaFilesPicked(
                    imageFiles: Array<pl.aprilapps.easyphotopicker.MediaFile>,
                    source: MediaSource
                ) {
                    val files: Array<pl.aprilapps.easyphotopicker.MediaFile> = imageFiles
                    if (files.isNotEmpty()) {
                        files.iterator().forEach {
                            val file = it.file
                            viewModel.mImageUri.add(Uri.fromFile(file))
                        }

                        callBack?.onActivityResult(
                            viewModel.mRequestCode,
                            viewModel.mImageUri
                        )
                    }

                }

                override fun onCanceled(source: MediaSource) {
                }

            })

        dismiss()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        try {
            if ((grantResults.isNotEmpty() &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED)
            ) {
                when (viewModel.mRequestCode) {
                    CAMERA_PICKER_REQUEST_CODE -> {
                        openCameraIntent()
                    }
                    IMAGE_PICKER_REQUEST_CODE -> {
                        openGalleryIntent()
                    }
                    VIDEO_GALLERY_PICKER_REQUEST_CODE -> {
                        openGalleryForVideo()
                    }
                    VIDEO_CAMERA_PICKER_REQUEST_CODE -> {
                        openCameraForVideo()
                    }
                }
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (permissions.isNotEmpty() && !requireActivity().shouldShowRequestPermissionRationale(
                        permissions[0]
                    )
                ) {
                    if (viewModel.mRequestCode == CAMERA_PICKER_REQUEST_CODE || viewModel.mRequestCode == VIDEO_CAMERA_PICKER_REQUEST_CODE) {
                        DialogUtils.goToSystemLocationSetting(
                            requireActivity(),
                            getString(R.string.camera_permission_msg)
                        )
                    } else {
                        DialogUtils.goToSystemLocationSetting(
                            requireActivity(),
                            getString(R.string.gallery_permission_msg)
                        )
                    }

                } else {
                    Log.d("Permission", "Denied")
                    Toast.makeText(
                        activity,
                        resources.getString(R.string.permission_denied),
                        Toast.LENGTH_LONG
                    ).show()
                }
            } else {
                Toast.makeText(
                    activity,
                    resources.getString(R.string.permission_denied),
                    Toast.LENGTH_LONG
                ).show()
            }
        } catch (e: Exception) {
        }
    }


    private fun createEasyImgObj() {
        easyImage = EasyImage.Builder(requireContext())

            // Chooser only
            // Will appear as a system chooser title, DEFAULT empty string
            //.setChooserTitle("Pick media")
            // Will tell chooser that it should show documents or gallery apps
            //.setChooserType(ChooserType.CAMERA_AND_DOCUMENTS)  you can use this or the one below
            //.setChooserType(ChooserType.CAMERA_AND_GALLERY)

            // Setting to true will cause taken pictures to show up in the device gallery, DEFAULT false
            .setCopyImagesToPublicGalleryFolder(false)
            // Sets the name for images stored if setCopyImagesToPublicGalleryFolder = true
            // Allow multiple picking
            .allowMultiple(true)
            .build()
    }

    private fun openGalleryForVideo() {
        TedImagePicker.with(requireContext()).mediaType(MediaType.VIDEO).showCameraTile(false)
            .max(1, getString(R.string.max_video_msg)).title(getString(R.string.selectVideo))
            .startMultiImage {
                callBack?.onActivityResult(viewModel.mRequestCode, it)
                dismiss()
            }
    }

    private fun openCameraForVideo() {

        if (PermissionUtils.isCameraPermissionGranted(context)) {
            easyImage?.openCameraForVideo(this)
        } else {
            PermissionUtils.requestCameraPermission(activity)
        }

    }


    private fun openGalleryIntent() {

        TedImagePicker.with(requireContext()).mediaType(MediaType.IMAGE).showCameraTile(false).max(
            viewModel.limitOfPickImage,
            StringHelper.getStringFromId(
                requireContext(),
                R.string.maximum_image_select_message,
                viewModel.limitOfPickImage.toString()
            ).toString()
        ).startMultiImage {
            callBack?.onActivityResult(viewModel.mRequestCode, it)
            dismiss()
        }
    }

    private fun openCameraIntent() {
        if (PermissionUtils.isCameraPermissionGranted(context)) {
            easyImage?.openCameraForImage(this)
        } else {
            PermissionUtils.requestCameraPermission(activity)
        }

    }

    private fun typePhoto() {
        binding.textSelect.text = getString(R.string.str_select_image)
        binding.cameraLayout.setOnClickListener {
            viewModel.mRequestCode = CAMERA_PICKER_REQUEST_CODE
            if (PermissionUtils.isCameraPermissionGranted(requireContext())) {
                openCameraIntent()
            } else {
                PermissionUtils.requestCameraPermission(requireActivity())
            }
        }

        binding.galleryLayout.setOnClickListener {
            viewModel.mRequestCode = IMAGE_PICKER_REQUEST_CODE
            if (PermissionUtils.isStoragePermissionGranted(requireContext())) {
                openGalleryIntent()
            } else {
                PermissionUtils.requestStoragePermission(requireActivity())
            }
        }
    }

    private fun typeVideo() {
        binding.textSelect.text = getString(R.string.str_select_video)
        binding.cameraLayout.setOnClickListener {
            viewModel.mRequestCode = VIDEO_CAMERA_PICKER_REQUEST_CODE
            if (PermissionUtils.isCameraPermissionGranted(requireContext())) {
                openCameraForVideo()
            } else {
                PermissionUtils.requestCameraPermission(requireActivity())
            }
        }

        binding.galleryLayout.setOnClickListener {
            viewModel.mRequestCode = VIDEO_GALLERY_PICKER_REQUEST_CODE
            if (PermissionUtils.isStoragePermissionGranted(requireContext())) {
                openGalleryForVideo()
            } else {
                PermissionUtils.requestStoragePermission(requireActivity())
            }
        }
    }

    interface CallBack {
        fun onActivityResult(
            requestCode: Int,
            mImageUri: List<Uri>?
        )
    }
}