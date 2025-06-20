package com.example.mygalleryapp_lab6

import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.String
import kotlin.Suppress

public class GalleryFragmentDirections private constructor() {
  private data class ActionGalleryFragmentToDetailFragment(
    public val imageUri: Uri,
    public val description: String = "",
  ) : NavDirections {
    public override val actionId: Int = R.id.action_galleryFragment_to_detailFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(Uri::class.java)) {
          result.putParcelable("imageUri", this.imageUri as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(Uri::class.java)) {
          result.putSerializable("imageUri", this.imageUri as Serializable)
        } else {
          throw UnsupportedOperationException(Uri::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        result.putString("description", this.description)
        return result
      }
  }

  public companion object {
    public fun actionGalleryFragmentToDetailFragment(imageUri: Uri, description: String = ""):
        NavDirections = ActionGalleryFragmentToDetailFragment(imageUri, description)
  }
}
