package com.lovoo.android.presenter

import com.lovoo.android.BuildConfig
import com.lovoo.android.LovooApplication
import com.lovoo.android.data.DataManager
import com.lovoo.android.data.model.episode.EpisodeResponse
import com.lovoo.android.ui.episode.EpisodePresenter
import com.lovoo.android.ui.episode.EpisodesMvpView
import com.lovoo.android.utils.TestSchedulerProvider
import io.reactivex.Observable
import io.reactivex.schedulers.TestScheduler
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.util.*

@RunWith(RobolectricTestRunner::class)
@Config(application = LovooApplication::class, constants = BuildConfig::class)
class EpisodePresenterTest {

    private var activity: EpisodesMvpView = mock(EpisodesMvpView::class.java)

    private var dataManager: DataManager = mock(DataManager::class.java)

    private lateinit var mEpisodePresenter: EpisodePresenter<EpisodesMvpView>

    private lateinit var testScheduler: TestScheduler

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        testScheduler = TestScheduler()
        val testSchedulerProvider = TestSchedulerProvider(testScheduler)

        mEpisodePresenter = EpisodePresenter<EpisodesMvpView>(dataManager, testSchedulerProvider)
        mEpisodePresenter.onAttach(activity)
    }

    @Test
    fun testFetchEpisodes() {
        val mockedResponse: EpisodeResponse? = mock(EpisodeResponse::class.java)

        doReturn(Observable.just(Arrays.asList(mockedResponse)))
                .`when`(dataManager)
                .getEpisodeList(30634)

        mEpisodePresenter.loadEpisode(30634)

        testScheduler.triggerActions()

        verify(activity).showLoading()

        @Suppress("UNCHECKED_CAST")
        verify(activity).onEpisodeResult(Arrays.asList(mockedResponse) as List<EpisodeResponse>)
    }

    @After
    fun tearDown() {
        mEpisodePresenter.onDetach()
    }

}