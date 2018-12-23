<?xml version="1.0" encoding="utf-8"?>
<!--
/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
-->

<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
                android:layout_width="match_parent"
                android:layout_height="58dip"
                style="@style/RtlOverlay.Widget.AppCompat.Search.DropDown">

    <!-- Icons come first in the layout, since their placement doesn't depend on
         the placement of the text views. -->
    <android.support.v7.internal.widget.TintImageView
               android:id="@android:id/icon1"
               android:layout_width="@dimen/abc_dropdownitem_icon_width"
               android:layout_height="48dip"
               android:scaleType="centerInside"
               android:layout_alignParentTop="true"
               android:layout_alignParentBottom="true"
               android:visibility="invisible"
               style="@style/RtlOverlay.Widget.AppCompat.Search.DropDown.Icon1" />

    <android.support.v7.internal.widget.TintImageView
               android:id="@+id/edit_query"
               android:layout_width="48dip"
               android:layout_height="48dip"
               android:scaleType="centerInside"
               android:layout_alignParentTop="true"
               android:layout_alignParentBottom="true"
               android:background="?attr/selectableItemBackground"
               android:visibility="gone"
               style="@style/RtlOverlay.Widget.AppCompat.Search.DropDown.Query" />

    <android.support.v7.internal.widget.TintImageView
               android:id="@id/android:icon2"
               android:layout_width="48dip"
               android:layout_hei