package com.example.mygalleryapp_lab6

import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.String
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class DetailFragmentArgs(
  public val imageUri: Uri,
  public val description: String = "",
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
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

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(Uri::class.java)) {
      result.set("imageUri", this.imageUri as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Uri::class.java)) {
      result.set("imageUri", this.imageUri as Serializable)
    } else {
      throw UnsupportedOperationException(Uri::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    result.set("description", this.description)
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): DetailFragmentArgs {
      bundle.setClassLoader(DetailFragmentArgs::class.java.classLoader)
      val __imageUri : Uri?
      if (bundle.containsKey("imageUri")) {
        if (Parcelable::class.java.isAssignableFrom(Uri::class.java) ||
            Serializable::class.java.isAssignableFrom(Uri::class.java)) {
          __imageUri = bundle.get("imageUri") as Uri?
        } else {
          throw UnsupportedOperationException(Uri::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__imageUri == null) {
          throw IllegalArgumentException("Argument \"imageUri\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"imageUri\" is missing and does not have an android:defaultValue")
      }
      val __description : String?
      if (bundle.containsKey("description")) {
        __description = bundle.getString("description")
        if (__description == null) {
          throw IllegalArgumentException("Argument \"description\" is marked as non-null but was passed a null value.")
        }
      } else {
        __description = ""
      }
      return DetailFragmentArgs(__imageUri, __description)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): DetailFragmentArgs {
      val __imageUri : Uri?
      if (savedStateHandle.contains("imageUri")) {
        if (Parcelable::class.java.isAssignableFrom(Uri::class.java) ||
            Serializable::class.java.isAssignableFrom(Uri::class.java)) {
          __imageUri = savedStateHandle.get<Uri?>("imageUri")
        } else {
          throw UnsupportedOperationException(Uri::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__imageUri == null) {
          throw IllegalArgumentException("Argument \"imageUri\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"imageUri\" is missing and does not have an android:defaultValue")
      }
      val __description : String?
      if (savedStateHandle.contains("description")) {
        __description = savedStateHandle["description"]
        if (__description == null) {
          throw IllegalArgumentException("Argument \"description\" is marked as non-null but was passed a null value")
        }
      } else {
        __description = ""
      }
      return DetailFragmentArgs(__imageUri, __description)
    }
  }
}
