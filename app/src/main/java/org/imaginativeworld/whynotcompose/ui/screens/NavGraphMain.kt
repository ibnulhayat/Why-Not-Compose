/*
 * Copyright 2021 Md. Mahmudul Hasan Shohag
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ------------------------------------------------------------------------
 *
 * Project: Why Not Compose!
 * Developed by: @ImaginativeShohag
 *
 * Md. Mahmudul Hasan Shohag
 * imaginativeshohag@gmail.com
 *
 * Source: https://github.com/ImaginativeShohag/Why-Not-Compose
 */

package org.imaginativeworld.whynotcompose.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import org.imaginativeworld.whynotcompose.ui.screens.animation.composeone.ComposeOneScreen
import org.imaginativeworld.whynotcompose.ui.screens.animation.index.AnimationIndexScreen
import org.imaginativeworld.whynotcompose.ui.screens.composition.appbar.AppBarScreen
import org.imaginativeworld.whynotcompose.ui.screens.composition.button.ButtonScreen
import org.imaginativeworld.whynotcompose.ui.screens.composition.card.CardScreen
import org.imaginativeworld.whynotcompose.ui.screens.composition.checkbox.CheckBoxScreen
import org.imaginativeworld.whynotcompose.ui.screens.composition.dropdown.DropDownMenuScreen
import org.imaginativeworld.whynotcompose.ui.screens.composition.index.CompositionIndexScreen
import org.imaginativeworld.whynotcompose.ui.screens.composition.list.*
import org.imaginativeworld.whynotcompose.ui.screens.composition.list.lazycolumn.LazyColumnSampleOneScreen
import org.imaginativeworld.whynotcompose.ui.screens.composition.list.lazycolumn.LazyColumnSampleTwoScreen
import org.imaginativeworld.whynotcompose.ui.screens.composition.listitem.ListItemScreen
import org.imaginativeworld.whynotcompose.ui.screens.composition.loadingindicator.LoadingIndicatorScreen
import org.imaginativeworld.whynotcompose.ui.screens.composition.radiobutton.RadioButtonScreen
import org.imaginativeworld.whynotcompose.ui.screens.composition.scaffold.*
import org.imaginativeworld.whynotcompose.ui.screens.composition.snackbar.SnackbarScreen
import org.imaginativeworld.whynotcompose.ui.screens.composition.switch.SwitchScreen
import org.imaginativeworld.whynotcompose.ui.screens.composition.textfield.TextFieldScreen
import org.imaginativeworld.whynotcompose.ui.screens.home.index.HomeIndexScreen
import org.imaginativeworld.whynotcompose.ui.screens.home.splash.SplashScreen
import org.imaginativeworld.whynotcompose.ui.screens.ui.index.UiIndexScreen
import org.imaginativeworld.whynotcompose.ui.screens.ui.webview.WebViewScreen
import org.imaginativeworld.whynotcompose.ui.screens.ui.webview.WebViewTarget
import org.imaginativeworld.whynotcompose.ui.screens.ui.webview.WebViewViewModel

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Animations : Screen("animation")
    object Compositions : Screen("composition")
    object UIs : Screen("ui")
    object Tutorials : Screen("tutorial")
}

sealed class HomeScreen(val route: String) {
    object Splash : HomeScreen("splash")
    object HomeIndex : HomeScreen("home/index")
}

sealed class AnimationsScreen(val route: String) {
    object AnimationIndex : AnimationsScreen("animation/index")
    object AnimationComposeOne : AnimationsScreen("animation/composeone")
    object AnimationEmudi : AnimationsScreen("animation/emudi")
    object AnimationFadeScale : AnimationsScreen("animation/fadescale")
    object AnimationRunningCar : AnimationsScreen("animation/runningcar")
}

sealed class CompositionsScreen(val route: String) {
    object CompositionIndex : CompositionsScreen("composition/index")

    object CompositionAppBar : CompositionsScreen("composition/appbar")
    object CompositionButton : CompositionsScreen("composition/button")
    object CompositionCard : CompositionsScreen("composition/card")
    object CompositionCheckBox : CompositionsScreen("composition/checkbox")
    object CompositionDialog : CompositionsScreen("composition/dialog")
    object CompositionDropDownMenu : CompositionsScreen("composition/dropdownmenu")

    object CompositionListIndex : CompositionsScreen("composition/list")
    object CompositionListColumn : CompositionsScreen("composition/list/column")
    object CompositionListRow : CompositionsScreen("composition/list/row")

    object CompositionListLazyColumnIndex : CompositionsScreen("composition/list/lazycolumn")
    object CompositionListLazyColumnOne : CompositionsScreen("composition/list/lazycolumn/1")
    object CompositionListLazyColumnTwo : CompositionsScreen("composition/list/lazycolumn/2")

    object CompositionListLazyRow : CompositionsScreen("composition/list/lazyrow")
    object CompositionListGridVertical : CompositionsScreen("composition/list/grid/vertical")

    object CompositionListItem : CompositionsScreen("composition/listitem")

    object CompositionLoadingIndicator : CompositionsScreen("composition/loadingindicator")
    object CompositionRadioButton : CompositionsScreen("composition/radiobutton")

    object CompositionScaffoldIndex : CompositionsScreen("composition/scaffold")
    object CompositionScaffoldOne : CompositionsScreen("composition/scaffold/1")
    object CompositionScaffoldTwo : CompositionsScreen("composition/scaffold/2")
    object CompositionScaffoldThree : CompositionsScreen("composition/scaffold/3")
    object CompositionScaffoldFour : CompositionsScreen("composition/scaffold/4")
    object CompositionScaffoldFive : CompositionsScreen("composition/scaffold/5")

    object CompositionSnackbar : CompositionsScreen("composition/snackbar")
    object CompositionSwitch : CompositionsScreen("composition/switch")
    object CompositionTextField : CompositionsScreen("composition/textfield")
}

sealed class UIsScreen(val route: String) {
    object UiIndex : UIsScreen("animation/index")

    object UiWebView : UIsScreen("animation/webview")
    object UiMapView : UIsScreen("animation/mapview")
    object UiOtpCodeView : UIsScreen("animation/otpcodeview")
}

sealed class TutorialsScreen(val route: String) {
    object TutorialIndex : TutorialsScreen("tutorial/index")
}

// ================================================================
// NavHost
// ================================================================

@Composable
fun NavHostMain(
    modifier: Modifier,
    navController: NavHostController,
    turnOnDarkMode: (Boolean) -> Unit,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        addHomeScreens(
            navController = navController,
            turnOnDarkMode = turnOnDarkMode,
        )
        addAnimationScreens(
            navController = navController
        )
        addCompositionScreens(
            navController = navController
        )
        addUiScreens(
            navController = navController
        )
        addTutorialScreens(
            navController = navController
        )
    }
}

// ================================================================
// Top Level Screens
// ================================================================

private fun NavGraphBuilder.addHomeScreens(
    navController: NavHostController,
    turnOnDarkMode: (Boolean) -> Unit,
) {
    navigation(
        route = Screen.Home.route,
        startDestination = HomeScreen.Splash.route
    ) {
        addHomeSplashScreen(
            navController = navController
        )
        addHomeIndexScreen(
            navController = navController,
            turnOnDarkMode = turnOnDarkMode,
        )
    }
}

private fun NavGraphBuilder.addAnimationScreens(
    navController: NavHostController,
) {
    navigation(
        route = Screen.Animations.route,
        startDestination = AnimationsScreen.AnimationIndex.route
    ) {
        addAnimationIndexScreen(
            navController = navController
        )

        // Below compositions will be just few lines.
        // So, we will not use functions for those.
        composable(AnimationsScreen.AnimationComposeOne.route) {
            ComposeOneScreen()
        }

        composable(AnimationsScreen.AnimationEmudi.route) {
            BlankScreen()
        }

        composable(AnimationsScreen.AnimationFadeScale.route) {
            BlankScreen()
        }

        composable(AnimationsScreen.AnimationRunningCar.route) {
            BlankScreen()
        }
    }
}

private fun NavGraphBuilder.addCompositionScreens(
    navController: NavHostController,
) {
    navigation(
        route = Screen.Compositions.route,
        startDestination = CompositionsScreen.CompositionIndex.route
    ) {
        addCompositionIndexScreen(
            navController = navController
        )

        // Below compositions will be just few lines.
        // So, we will not use functions for those.
        composable(CompositionsScreen.CompositionAppBar.route) {
            AppBarScreen()
        }

        composable(CompositionsScreen.CompositionButton.route) {
            ButtonScreen()
        }

        composable(CompositionsScreen.CompositionCard.route) {
            CardScreen()
        }

        composable(CompositionsScreen.CompositionCheckBox.route) {
            CheckBoxScreen()
        }

        composable(CompositionsScreen.CompositionDialog.route) {
            BlankScreen()
        }

        composable(CompositionsScreen.CompositionDropDownMenu.route) {
            DropDownMenuScreen()
        }

        composable(CompositionsScreen.CompositionListIndex.route) {
            ListIndexScreen(
                navigate = { screen ->
                    navController.navigate(screen.route)
                },
            )
        }

        composable(CompositionsScreen.CompositionListColumn.route) {
            ListColumnScreen()
        }

        composable(CompositionsScreen.CompositionListRow.route) {
            ListRowScreen()
        }

        composable(CompositionsScreen.CompositionListLazyColumnIndex.route) {
            LazyColumnIndexScreen(
                navigate = { screen ->
                    navController.navigate(screen.route)
                },
            )
        }

        composable(CompositionsScreen.CompositionListLazyColumnOne.route) {
            LazyColumnSampleOneScreen()
        }

        composable(CompositionsScreen.CompositionListLazyColumnTwo.route) {
            LazyColumnSampleTwoScreen()
        }

        composable(CompositionsScreen.CompositionListLazyRow.route) {
            LazyRowScreen()
        }

        composable(CompositionsScreen.CompositionListGridVertical.route) {
            LazyVerticalGridScreen()
        }

        composable(CompositionsScreen.CompositionListItem.route) {
            ListItemScreen()
        }

        composable(CompositionsScreen.CompositionLoadingIndicator.route) {
            LoadingIndicatorScreen()
        }

        composable(CompositionsScreen.CompositionRadioButton.route) {
            RadioButtonScreen()
        }

        composable(CompositionsScreen.CompositionScaffoldIndex.route) {
            ScaffoldIndexScreen(
                navigate = { screen ->
                    navController.navigate(screen.route)
                },
            )
        }

        composable(CompositionsScreen.CompositionScaffoldOne.route) {
            SimpleScaffoldWithTopBarScreen()
        }

        composable(CompositionsScreen.CompositionScaffoldTwo.route) {
            ScaffoldWithBottomBarAndCutoutScreen()
        }

        composable(CompositionsScreen.CompositionScaffoldThree.route) {
            ScaffoldWithSimpleSnackbarScreen()
        }

        composable(CompositionsScreen.CompositionScaffoldFour.route) {
            ScaffoldWithCustomSnackbarScreen()
        }

        composable(CompositionsScreen.CompositionScaffoldFive.route) {
            ScaffoldWithCoroutinesSnackbarScreen()
        }

        composable(CompositionsScreen.CompositionSnackbar.route) {
            SnackbarScreen(
                navigate = { route ->
                    navController.navigate(route)
                }
            )
        }

        composable(CompositionsScreen.CompositionSwitch.route) {
            SwitchScreen()
        }

        composable(CompositionsScreen.CompositionTextField.route) {
            TextFieldScreen()
        }
    }
}

private fun NavGraphBuilder.addUiScreens(
    navController: NavHostController,
) {
    navigation(
        route = Screen.UIs.route,
        startDestination = AnimationsScreen.AnimationIndex.route
    ) {
        addUiIndexScreen(
            navController = navController
        )

        // Below compositions will be just few lines.
        // So, we will not use functions for those.
        composable(UIsScreen.UiWebView.route) {
            val viewModel: WebViewViewModel = hiltViewModel()

            WebViewScreen(
                viewModel = viewModel,
                target = WebViewTarget.AboutMe,
                goBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(UIsScreen.UiMapView.route) {
            BlankScreen()
        }

        composable(UIsScreen.UiOtpCodeView.route) {
            BlankScreen()
        }
    }
}

private fun NavGraphBuilder.addTutorialScreens(
    navController: NavHostController,
) {
    navigation(
        route = Screen.Tutorials.route,
        startDestination = TutorialsScreen.TutorialIndex.route
    ) {
        addTutorialIndexScreen(
            navController = navController
        )

        // Below compositions will be just few lines.
        // So, we will not use functions for those.
//        composable(TutorialsScreen.xyz.route) {
//            BlankScreen()
//        }
    }
}

// ================================================================
// Leaf Screens
// ================================================================

private fun NavGraphBuilder.addHomeSplashScreen(
    navController: NavHostController,
) {
    composable(HomeScreen.Splash.route) {
        SplashScreen(
            gotoHomeIndex = {
                navController.navigate(HomeScreen.HomeIndex.route) {
                    popUpTo(HomeScreen.Splash.route) {
                        inclusive = true
                    }
                }
            }
        )
    }
}

private fun NavGraphBuilder.addHomeIndexScreen(
    navController: NavHostController,
    turnOnDarkMode: (Boolean) -> Unit,
) {
    composable(HomeScreen.HomeIndex.route) {
        HomeIndexScreen(
            navigate = { screen ->
                navController.navigate(screen.route)
            },
            turnOnDarkMode = turnOnDarkMode
        )
    }
}

// ----------------------------------------------------------------

private fun NavGraphBuilder.addAnimationIndexScreen(
    navController: NavHostController,
) {
    composable(AnimationsScreen.AnimationIndex.route) {
        AnimationIndexScreen(
            navigate = { screen ->
                navController.navigate(screen.route)
            },
        )
    }
}

// ----------------------------------------------------------------

private fun NavGraphBuilder.addCompositionIndexScreen(
    navController: NavHostController,
) {
    composable(CompositionsScreen.CompositionIndex.route) {
        CompositionIndexScreen(
            navigate = { screen ->
                navController.navigate(screen.route)
            }
        )
    }
}

// ----------------------------------------------------------------

private fun NavGraphBuilder.addUiIndexScreen(
    navController: NavHostController,
) {
    composable(UIsScreen.UiIndex.route) {
        UiIndexScreen(
            navigate = { screen ->
                navController.navigate(screen.route)
            }
        )
    }
}

// ----------------------------------------------------------------

private fun NavGraphBuilder.addTutorialIndexScreen(
    navController: NavHostController,
) {
    composable(TutorialsScreen.TutorialIndex.route) {
        BlankScreen()
    }
}

// ================================================================
// Blank Screen
// ================================================================

@Composable
private fun BlankScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Coming soon...")
    }
}