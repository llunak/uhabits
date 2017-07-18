/*
 * Copyright (C) 2017 Álinson Santos Xavier <isoron@gmail.com>
 *
 * This file is part of Loop Habit Tracker.
 *
 * Loop Habit Tracker is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * Loop Habit Tracker is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.isoron.uhabits.database;

import android.content.*;
import android.database.sqlite.*;
import android.support.annotation.*;

import org.isoron.androidbase.*;
import org.isoron.uhabits.core.database.*;

import java.io.*;

import javax.inject.*;

public class AndroidDatabaseOpener implements DatabaseOpener
{
    private Context context;

    @Inject
    public AndroidDatabaseOpener(@NonNull @AppContext Context context)
    {
        this.context = context;
    }

    @Override
    public Database open(@NonNull File file)
    {
        return new AndroidDatabase(
            SQLiteDatabase.openDatabase(file.getAbsolutePath(), null,
                SQLiteDatabase.OPEN_READWRITE));
    }
}