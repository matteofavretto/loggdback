package org.matteofavretto.command;

import org.matteofavretto.model.common.CommandResponse;

public interface BaseCommand<T> {
    String getName();
    CommandResponse run(T input);
}
