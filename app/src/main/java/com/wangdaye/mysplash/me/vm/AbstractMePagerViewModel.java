package com.wangdaye.mysplash.me.vm;

import com.wangdaye.mysplash.common.basic.model.ListResource;
import com.wangdaye.mysplash.common.basic.vm.PagerViewModel;
import com.wangdaye.mysplash.common.utils.bus.MessageBus;
import com.wangdaye.mysplash.common.utils.manager.AuthManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public abstract class AbstractMePagerViewModel<T, E> extends PagerViewModel<T>
        implements Consumer<E> {

    @NonNull private Disposable disposable;
    @Nullable private String username;

    public AbstractMePagerViewModel(Class<E> eventType) {
        this.disposable = MessageBus.getInstance()
                .toObservable(eventType)
                .subscribe(this);
        this.username = null;
    }

    @Override
    protected boolean init(@NonNull ListResource<T> resource) {
        if (username == null) {
            username = AuthManager.getInstance().getUsername();
        }
        return super.init(resource);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }

    @Nullable
    public String getUsername() {
        return username;
    }

    protected void setUsername(@Nullable String username) {
        this.username = username;
    }
}
